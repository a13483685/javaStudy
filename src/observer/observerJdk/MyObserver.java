package observer.observerJdk;

import java.util.Observable;
import java.util.Observer;

//�����������巢����
class MyObserver implements Observer {//���ܸı����
    //�����ݸı�ʱ��֪ͨ������
    public void update(Observable o, Object arg) {
        System.out.println("data changed to"+(String)arg);
    }
}