package thread.concurrent.ThreadLifeCycle;

import java.util.Observable;
import java.util.Observer;

public class ObervableThread<T> extends Thread implements Observer {
    private final TaskLifeCycle<T> lifeCycle;

    private final Task<T> task;

    private thread.concurrent.ThreadLifeCycle.Observable.Cycle cycle;

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
    public void run() {
        super.run();
    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
