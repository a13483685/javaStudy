package thread.concurrent.ReadAndWriteLock;

public interface ReadWriteLock {
    //创建reader锁
    Lock readLock();
    //创建write锁
    Lock writeLock();
    //获取当前有多少线程正在执行写操作
    int getWritingWriters();
    //获取当前有多少线程正在等待获取写入锁
    int getWatingWrites();
    //获取当前有多少线程正在等待获取reader锁
    int getReadingReads();

    //工厂方法，创建ReadWriteLock
    static ReadWriteLock readWriteLock(){
        return new ReadWriteLockImpl();
    }
    //工厂方法，创建ReadWriteLock，并传入preferWrite
    static ReadWriteLock readWriteLock(boolean preferWrite){
        return new ReadWriteLockImpl(preferWrite);
    }
}
