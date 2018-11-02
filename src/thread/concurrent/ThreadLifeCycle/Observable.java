package thread.concurrent.ThreadLifeCycle;

public interface Observable {
    enum Cycle{
        STARTED,RUNNING,DONE,ERROR
    }
    //获取当前任务的生命周期状态
    Cycle getCycle();

    //定义启动线程的方法，主要是为了屏蔽Thread的其他方法
    void start();

    //void 定义打断线程的方法，主要是为了屏蔽Thread的其他方法
    void interrupt();
}
