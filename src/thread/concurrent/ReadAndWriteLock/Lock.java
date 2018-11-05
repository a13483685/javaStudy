package thread.concurrent.ReadAndWriteLock;

public interface Lock {
    //获得显示锁
    void lock() throws InterruptedException;
    //释放获取的锁
    void unLock();
}
