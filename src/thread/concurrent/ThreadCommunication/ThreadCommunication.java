package thread.concurrent.ThreadCommunication;

import java.util.concurrent.TimeUnit;

/**
 * wait和notify的用法：
 * 1.单线程通讯
 */
public class ThreadCommunication {
    public static void main(String[] args){
        final EventQueue eventQueue = new EventQueue();
        new Thread(() ->{
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();

        new Thread(() -> {
            for (;;){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);//10毫秒模拟要处理的逻辑
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }

}
