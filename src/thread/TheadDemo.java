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
//                Thread.currentThread().yield();//效果不明显，cpu释放资源，下一时刻依然会被线程强占
//            }
            if (i == 10) {
                try {
                    thread.join();//完全释放了主线程，thread线程加入，当thread线程执行完成之后主线程才会执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+",is Alive ?"+Thread.currentThread().isAlive());
        }
        System.out.println(thread.getName()+",is Alive ?"+thread.isAlive());
    }
}
