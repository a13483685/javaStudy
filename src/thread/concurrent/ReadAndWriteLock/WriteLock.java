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
                readWriteLock.incrementWatingWrites();
                while (readWriteLock.getReadingReads()>0 || readWriteLock.getWatingWrites()>0){
                    readWriteLock.getMUTEX().wait();
                }
            }finally {

            }

        }
    }

    @Override
    public void unLock() {

    }
}
