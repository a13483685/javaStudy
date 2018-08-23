package observer.observerJdk;

import java.util.Observable;
import java.util.Observer;

//第二步，定义监听器
public class MyObservable extends Observable {
    //第一步，封装消息数据
    private String data;

    public void changeValue(String fValue) {
        data = fValue;
        setChanged();
    }
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
}
