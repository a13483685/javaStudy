package thread.concurrent.ThreadLifeCycle;

import java.util.Observable;
import java.util.Observer;
import thread.concurrent.ThreadLifeCycle.Observable.Cycle;

public class ObervableThread<T> extends Thread implements thread.concurrent.ThreadLifeCycle.Observable {
    private final TaskLifeCycle<T> lifeCycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObervableThread(Task<T> task){
        this(new TaskLifeCycle.EmptyLifeCycle<>(),task);
    }

    public ObervableThread(TaskLifeCycle<T> tEmptyLifeCycle, Task<T> task) {
        super();
        if(task ==null){
            throw new IllegalArgumentException("The task is required");
        }
        this.lifeCycle = tEmptyLifeCycle;
        this.task = task;
    }

    @Override
    public final void run() {
        this.update(Cycle.STARTED,null,null);
        try {
            this.update(Cycle.RUNNING,null,null);

            T result = this.task.call();
            this.update(Cycle.DONE,result,null);
        }catch (Exception e){
            this.update(Cycle.ERROR,null,e);
        }
    }

    public void update(Cycle cycle, T result,Exception e) {
        this.cycle = cycle;
        if(lifeCycle == null){
            return;
        }
        try {
            switch (cycle){
                case STARTED:
                    this.lifeCycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifeCycle.onRunnning(currentThread());
                    break;
                case DONE:
                    this.lifeCycle.onFinsh(currentThread(),result);
                    break;
                case ERROR:
                    this.lifeCycle.onError(currentThread(),e);
                    break;
            }
        }catch (Exception e1){
            if(cycle == Cycle.ERROR){
                throw e1;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
