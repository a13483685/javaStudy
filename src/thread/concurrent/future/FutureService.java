package thread.concurrent.future;



public interface FutureService<IN,OUT> {
    //提交不需要返回值得任务，Futrue.get方法返回的将是null
    Future<?> submit(Runnable runnable);
    //提交需要返回值的任务，其中Task接口代替了Runnable接口
    Future<OUT> submit(Task<IN,OUT> task, IN input);

    static <T,R> FutureService<T,R> newService(){
        return new FutureServiceImpl();
    }
}
