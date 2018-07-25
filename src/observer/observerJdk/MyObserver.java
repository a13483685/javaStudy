package observer.observerJdk;

import java.util.Observable;
import java.util.Observer;

//第三步，定义发送类
class MyObserver implements Observer {//接受改变的类
    //当数据改变时，通知发送类
    public void update(Observable o, Object arg) {
        System.out.println("data changed to"+(String)arg);
    }
}