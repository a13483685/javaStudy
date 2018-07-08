package thread;
//线程优先级 线程优先级最小的是1 最大的是10 正常是5
//优先级高的抢占到cpu的资源的概率要高些
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
