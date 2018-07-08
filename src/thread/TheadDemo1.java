package thread;
//�߳����ȼ� �߳����ȼ���С����1 ������10 ������5
//���ȼ��ߵ���ռ��cpu����Դ�ĸ���Ҫ��Щ
public class TheadDemo1 extends Thread{

    @Override
    public void run() {
        super.run();
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+",i="+i);
            if(i == 30)
            {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String args[]){
        TheadDemo1 thread = new TheadDemo1();
        thread.setName("xie");
        thread.start();

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getPriority()+",i="+i);
        }
    }
}
