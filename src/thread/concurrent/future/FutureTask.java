package thread.concurrent.future;

public class FutureTask<T> implements Future<T> {
    //计算结果
    private T result;
    //任务是否完成
    private boolean isDone = false;
    //定义对象锁
    private final Object Lock = new Object();

    @Override
    public T get() throws InterruptedException {
        synchronized (Lock){
            //当任务还未完成时，调用get方法会被挂起而进入睡眠
            while (!isDone){
                Lock.wait();
            }
        }
        //返回最终计算结果
        return result;
    }

    protected void finsh(T result){
        synchronized (Lock){
            if(isDone){
                return;
            }
            //计算完成，为result指定结果，并且将isDone设为true,同时唤醒阻塞中的线程
            this.result = result;
            this.isDone = true;
            Lock.notifyAll();
        }
    }
    //返回当前任务是否已经完成
    @Override
    public boolean done() {
        return isDone;
    }
}
