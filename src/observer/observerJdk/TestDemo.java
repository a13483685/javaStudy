package observer.observerJdk;

public class TestDemo {
    public static void main(String args[]){
        MyObservable myOservable = new MyObservable();
        myOservable.addObserver(new MyObserver());
        String sValue = "Hello Msg";
        myOservable.changeValue(sValue);
        myOservable.notifyObservers(sValue + "!");//ˢ�����ݣ�֪ͨObservable����
    }
}
