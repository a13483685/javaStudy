package observer.java;

import java.util.ArrayList;
import java.util.List;

public class subject {
    static List<observerJava> observers = new ArrayList<>();

    private void atach(observerJava obs){
        observers.add(obs);
    }

    private void detach(observerJava obs){
        if(obs!=null)
        observers.remove(obs);
    }

    private static void notifyMsg(){
        for (observerJava observer:observers) {
            observer.update("ÄãÃÇºÃ£¡");
        }
    }

    public static void main(String string[]){
        observerJava observer01 = new GF1Observer();
        observerJava observer02 = new GF2Observer();
        observerJava observer03 = new GF3Observer();
        observers.add(observer01);
        observers.add(observer02);
        observers.add(observer03);
        notifyMsg();
    }
}
