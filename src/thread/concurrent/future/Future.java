package thread.concurrent.future;

public interface Future<T> {
    //返回计算后的结果
    T get() throws InterruptedException;
    //判断任务是否被执行完
    boolean done();
}
