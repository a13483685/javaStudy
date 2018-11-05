package thread.concurrent.ReadAndWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * 如何使用读写锁
 */
public class ShareDate {
    //定义共享数据
    private final List<Character> container  =new ArrayList<>();
    //构造ReadWriteLock
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();
    //创建读取锁
    private final Lock readLock = readWriteLock.readLock();
    //创建写入锁
    private final Lock writeLock = readWriteLock.writeLock();
    private final int length;
    public ShareDate(int length){
        this.length = length;
        for (int i =0;i<length;i++){
            container.add(i,'c');
        }
    }
    public char[] read() throws InterruptedException{
        try {
            //首先使用读锁进行lock
            readLock.lock();
            char[] newbuffer = new char[length];
            for (int i =0;i<length;i++){
                newbuffer[i] = container.get(i);
            }
            slowly();
            return newbuffer;
        }finally {
            //当操作结束之后，将锁释放
            readLock.unLock();
        }
    }
    public void write(char buf){
        try {
            for (int i=0;i<length-1;i++){
                container.add(i,buf);
            }
            slowly();
        }finally {
            writeLock.unLock();
        }
    }

    private void slowly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
