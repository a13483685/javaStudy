package thread.ticket;
//���߳�ʹ�õ�demo
class Window extends Thread{
    public static int i = 300;//�˴�Ҫ�õ�static ��Ϊ��Ҫ����
    @Override
    public void run() {
        super.run();
        while (i>0){
            i--;
            System.out.println("remian tickets num is :"+i);
        }
    }
}

public class TicketThread {

    public static void main(String str[]){
        Window win1 = new Window();
        Window win2 = new Window();
        Window win3 = new Window();
        win1.start();
        win2.start();
        win3.start();
    }
}
