package thread.concurrent.ReadAndWriteLock;

public class ReadWriteLockImpl implements ReadWriteLock{
    //定义对象锁
    private final Object MUTEX = new Object();
    //当前有多少个线程正在写入
    private int writingWriters = 0;
    //当先有多少个线程正在等待写入
    private int waitingWrites = 0;
    //当前有多少个线程正在read
    private int readingReaders = 0;
    //read和write的偏好设置
    private boolean preferWrite;

    public ReadWriteLockImpl(){
        this(true);
    }

    /**
     * 构造ReadWriteLockImpl 并且传入preferWrite
     * @param preferWrite
     */
    public ReadWriteLockImpl(boolean preferWrite){
        this.preferWrite = preferWrite;
    }

    //创建read Lock
    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    //使等待写入的线程数量增加
    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWatingWrites() {
        return this.waitingWrites;
    }

    @Override
    public int getReadingReads() {
        return this.readingReaders;
    }

    void incrementWriteWrites(){
        this.writingWriters++;
    }

    void incrementWatingWrites(){
        this.waitingWrites++;
    }

    void incrementReadingReads(){
        this.readingReaders++;
    }

    void decrementWriteWrites(){
        this.writingWriters--;
    }

    void decrementWatingWrites(){
        this.waitingWrites--;
    }

    void decrementReadingReads(){
        this.readingReaders--;
    }

    public Object getMUTEX() {
        return this.MUTEX;
    }

    boolean getPerferWrite(){
        return this.preferWrite;
    }

    void changePrefer(boolean preferWrite){
        this.preferWrite = preferWrite;
    }
}
