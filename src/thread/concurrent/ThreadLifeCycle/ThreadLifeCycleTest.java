package thread.concurrent.ThreadLifeCycle;

import java.util.concurrent.TimeUnit;

public class ThreadLifeCycleTest {
//    public static void main(String[] strings){
//        Observable observable = new ObervableThread<>(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(" finished done.");
//            return null;
//        });
//        observable.start();
//    }

    public static void main(String[] args){
        TaskLifeCycle<String> lifeCycle = new TaskLifeCycle.EmptyLifeCycle<String>(){
            @Override
            public void onStart(Thread thread) {
                System.out.println("start()");
            }

            @Override
            public void onFinsh(Thread thread, String result) {
                System.out.println("The result is "+result);
            }
        };

        ObervableThread<String> obervableThread = new ObervableThread<>(lifeCycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello Observer";
        });
        obervableThread.start();
    }
}
