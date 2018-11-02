package thread.concurrent.ThreadLifeCycle;

public interface TaskLifeCycle<T> {
    //任务启动时触发onStart
    void onStart(Thread thread);
    //任务运行时触发onRunnning
    void onRunnning(Thread thread);
    //任务运行结束时会触发OnFinsh,其中result是任务执行结束之后的结果
    void onFinsh(Thread thread,T result);
    //任务执行报错时会触发Onerror方法
    void onError(Thread thread,Exception e);

    //生命周期接口的空实现
    class EmptyLifeCycle<T> implements TaskLifeCycle<T>{

        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunnning(Thread thread) {

        }

        @Override
        public void onFinsh(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }


}
