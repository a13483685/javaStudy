package thread.concurrent.ReadAndWriteLock;

public class ReadLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock){
        this.readWriteLock = readWriteLock;
    }
    @Override
    public void lock() throws InterruptedException {
        //使用Mutex作为锁
        synchronized (readWriteLock.getMUTEX()){
            //若此时有线程在进行写操作，或者有写线程在等待并且偏向写锁的标志位true时，就会无法获得读锁，只能被挂起
            while (readWriteLock.getWatingWrites()>0 ||(readWriteLock.getPerferWrite() && readWriteLock.getWatingWrites()>0)){
                readWriteLock.getMUTEX().wait();
            }
            //成功获得读锁，并且使readingReaders的数量增加
            readWriteLock.incrementReadingReads();
        }
    }

    @Override
    public void unLock() {
        synchronized (readWriteLock.getMUTEX()){
            /**
             * 释放锁的过程就是是的当前reading的数量减一
             * 将perferWriter设置为true，可以使得write线程获得更多机会
             * 通知唤醒与Mutex关联monitor waitset中的线程
             */
            readWriteLock.decrementReadingReads();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
