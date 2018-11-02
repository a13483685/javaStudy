package thread.concurrent.Flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("CSA","CEA","JNA");
    public static void main(String[] strings){
        List<String> resluts = seach("SH","BJ");
        System.out.println("================result=================");
        resluts.forEach(System.out::println);
    }
    private static List<String> seach(String original,String dest){
        final List<String> result = new ArrayList<>();
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> createSearchTask(f, original, dest)).collect(Collectors.toList());
        //分别启动这几个线程
        tasks.forEach(Thread::start);
        //分别调用每一个线程的join方法，阻塞当前线程
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);
        return result;
    }

    private static FightQueryTask createSearchTask(String fight,String origin,String dest){
        return new FightQueryTask(fight,origin,dest);
    }
}
