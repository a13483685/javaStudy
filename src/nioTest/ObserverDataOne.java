package nioTest;

public class ObserverDataOne implements ObserverData{
    @Override
    public void update(String string) {
        System.out.println("getMsg is :"+string);
    }
}
