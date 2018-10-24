package net.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientAPI {
    DatagramSocket client=null;
    InetAddress addr=null;
    int port=-1;
    IUDPListener listener;

    /**
     *
     * @param desAddr 发送的目标地址
     * @param desPort 目标端口
     * @param listener 接收到数据的监听
     * @throws IOException
     */
    public UDPClientAPI(String desAddr,int desPort,int thisPort,IUDPListener listener) throws IOException{
        addr = InetAddress.getByName(desAddr);//要发送到的ip
        port=desPort;
        client = new DatagramSocket(thisPort);//本机接受数据的端口
        this.listener=listener;
    }

    /**
     *发送一个字节数组
     * @param bytes
     * @throws IOException
     */
    public void sendData(byte[]bytes) throws IOException{
        if (addr==null||port==-1) {
            throw new NullPointerException("请重新初始化");
            //return;
        }
        DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,addr, port);
        client.send(sendPacket);
    }

    /**
     * 简单的循环执行读取数据，在线程中执行
     * @throws IOException
     */
    public void simpleWaitingRead(boolean isRead) throws IOException{
        if (isRead) {
            if (!isCycle) {//未进行循环执行循环读取
                isCycle=true;//执行循环
                CycleRead();//执行循环操作
            }
        }else {
            if (isCycle) {//正在运行时执行停止循环
                isCycle=false;//停止循环
            }
        }
    }
    boolean isCycle=false;
    /**
     * 执行循环读取操作
     * @throws IOException
     */

    public void CycleRead() {

        new Thread(){public void run() {
            while(isCycle){
                System.out.println("into the cycleRead");
                byte[]read_b=new byte[1024];//作为数据缓存区,读取数据最大长度无法超出2K
                DatagramPacket recvPacket = new DatagramPacket(read_b, read_b.length);//缓存区装进包中
//                System.out.println("recv is :"+new String(read_b));
                System.out.println("----------------------------");
                try {
//                    System.out.println("1111111111111111111");
                    client.receive(recvPacket);//阻塞读取数据
//                    System.out.println("2222222222222222222");
                    byte[]vaild_b=new byte[recvPacket.getLength()];//有效数据
                    System.arraycopy(read_b, 0, vaild_b, 0, vaild_b.length);//取出有效数据
                    listener.onReceiveData(vaild_b);//通过监听器回调有效数据
                } catch (IOException e) {
                    if (!e.getMessage().equals("Socket closed")) {
                        e.printStackTrace();
                    }
                }//进行包读取,阻塞型
            }
        };}.start();
    }
    /**
     * 关闭所有
     */
    public void CloseAll(){
        isCycle=false;
        port=-1;
        if (client!=null&&!client.isClosed()) {
            client.close();
        }
    }

}

