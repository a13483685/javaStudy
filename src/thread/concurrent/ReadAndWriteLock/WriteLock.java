package thread.concurrent.ReadAndWriteLock;


public class WriteLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;
    WriteLock(ReadWriteLockImpl readWriteLock){
        this.readWriteLock = readWriteLock;
    }
    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTEX()){
            try {
                //首先使等待获取写入锁的数字加一
                readWriteLock.incrementWatingWrites();
                //如果这个时候有别的线程正在进行写操作，那么当前线程会被挂起
                while (readWriteLock.getReadingReads()>0 || readWriteLock.getWatingWrites()>0){
                    readWriteLock.getMUTEX().wait();
                }
            }finally {
                //成功获取到了写入锁，使获取等待写入锁的计数器减一
                this.readWriteLock.decrementWatingWrites();
            }
            //将正在写入的线程数量加一
            readWriteLock.incrementWriteWrites();
        }
    }

    @Override
    public void unLock() {
        synchronized (readWriteLock.getMUTEX()){
            //减少正在写入锁的线程计数器
            readWriteLock.decrementWatingWrites();
            //将偏好状态设置为false，可以使得读锁被最快速的获得
            readWriteLock.changePrefer(false);
            //通知唤醒其他在Mutex monitor waitset 中的线程
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
