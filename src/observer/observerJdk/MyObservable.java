package observer.observerJdk;

import java.util.Observable;
import java.util.Observer;

//�ڶ��������������
public class MyObservable extends Observable {
    //��һ������װ��Ϣ����
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
