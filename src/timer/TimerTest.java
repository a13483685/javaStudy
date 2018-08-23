package timer;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    @Test
    public void testTimerDemo1(){
//        ScheduledThreadPoolExecutor scheduled = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(10);
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);

        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                loge("time:");
                System.out.println(Thread.currentThread().getName() + " run ");
            }
        }, 0, 50, TimeUnit.MILLISECONDS);//0��ʾ�״�ִ��������ӳ�ʱ�䣬40��ʾÿ��ִ������ļ��ʱ�䣬TimeUnit.MILLISECONDSִ�е�ʱ������ֵ��λ

//        for (int i = 0; i < 10; ++i) {
//            executor.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " run ");
//                }
//            } , 2 , TimeUnit.SECONDS);
//        }
//        executor.shutdown();
    }
}
