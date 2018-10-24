package thread.ConcurrentTest;

import java.util.concurrent.CountDownLatch;

/**
 * 内部维护了一个计数器，里面对计数器的操作都是原子的。使用的时候先初始化一个初值
 * 当这个初值最后减为0的时候，就停止await状态
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        //所有线程阻塞，然后统一开始
        CountDownLatch begin = new CountDownLatch(1);
        //主线程阻塞，直到所有分线程执行完毕
        CountDownLatch end = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        System.out.println(Thread.currentThread().getName() + " 起跑");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        try {
            System.out.println("1秒后统一开始");
            Thread.sleep(1000);
            begin.countDown();//begin减1之后 5个线程的begin.await的停止阻塞状态
            end.await();//begin 之后 end进入阻塞状态 在线程执行countDown() 之后就停止比赛
            System.out.println("停止比赛");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
