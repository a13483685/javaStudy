package thread.concurrent;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
    public static void main(String[] args){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    System.out.println("I am sleeping");
                    TimeUnit.MINUTES.sleep(1);

                } catch (InterruptedException e) {
                    System.out.println("I am interrupter");
                }
            }
        };
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
            thread.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
