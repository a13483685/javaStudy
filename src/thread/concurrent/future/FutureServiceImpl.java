package thread.concurrent.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * FutureServiceImpl的主要作用在于当提交任务的时候创建一个新的线程来受理该任务
 * 进而达到任务异步执行的效果
 * @param <IN>
 * @param <OUT>
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN,OUT> {

    private final static String FUTURE_THREAD_PTRFIX = "FUTURE-";

    private final AtomicInteger nextCount = new AtomicInteger(0);

    private String getNextName(){
        return FUTURE_THREAD_PTRFIX + nextCount.getAndIncrement();
    }
    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
            runnable.run();
            future.finsh(null);
        }).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT result = task.get(input);
            future.finsh(result);
        }).start();
        return future;
    }
}
