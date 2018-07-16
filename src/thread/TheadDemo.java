package thread;

public class TheadDemo extends Thread{

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
        TheadDemo thread = new TheadDemo();
        thread.setName("xie");
        thread.start();

        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+",i="+i);

//            if(i%10 == 3)
//            {
//                Thread.currentThread().yield();//Ч�������ԣ�cpu�ͷ���Դ����һʱ����Ȼ�ᱻ�߳�ǿռ
//            }
            if (i == 10) {
                try {
                    thread.join();//��ȫ�ͷ������̣߳�thread�̼߳��룬��thread�߳�ִ�����֮�����̲߳Ż�ִ��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+",is Alive ?"+Thread.currentThread().isAlive());
        }
        System.out.println(thread.getName()+",is Alive ?"+thread.isAlive());
    }
}
