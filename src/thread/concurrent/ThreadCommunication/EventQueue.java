package thread.concurrent.ThreadCommunication;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

public class EventQueue {
    public final String TAG = this.getClass().getName();
    private final int max;
    static class Event{

    }
    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVECT =10;

    public EventQueue(int max) {
        this.max = max;
    }

    public EventQueue(){
        this(DEFAULT_MAX_EVECT);
    }

    public void offer(Event event){
        synchronized (eventQueue){
            if (eventQueue.size()>max){
                try {
                    eventQueue.wait();
                    console("the queue is full.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is submited");
            eventQueue.add(event);
            eventQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                console("the queue is full.");
            }
            Event last = eventQueue.getLast();
            eventQueue.notify();
            return last;
        }
    }

    private void console(String msg){
        System.out.printf("%s:%s\n",currentThread().getName(),msg);
    }

}
