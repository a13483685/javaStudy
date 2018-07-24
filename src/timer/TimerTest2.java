package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTest2 {
    static ScheduledThreadPoolExecutor stp = null;
    static int index;

    private static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }


    private static class MyTask implements Runnable {

        @Override
        public void run() {
            index++;
            System.out.println("2= " + getTimes()+" "  +index);
//            if(index >=10){
//                stp.shutdown();
//                if(stp.isShutdown()){
//                    System.out.println("ֹͣ�ˣ�������");
//                }
//            }
        }
    }
    public static void main(String[] args)
    {
        stp = new ScheduledThreadPoolExecutor(5);
        MyTask mytask = new MyTask();
        //mytaskΪ�̣߳�2���״�ִ�е��ӳ�ʱ�䣬���һ������Ϊʱ�䵥λ
//        stp.schedule(mytask, 2, TimeUnit.SECONDS);
        // �״�ִ���ӳ�2�룬֮���ִ��������1��
//        stp.scheduleAtFixedRate(mytask, 2, 1,TimeUnit.SECONDS );
        //�״�ִ���ӳ�2�룬֮�����һ�������������һ������ʼʱ1��
        stp.scheduleWithFixedDelay(mytask, 2, 1, TimeUnit.SECONDS);

    }
}
