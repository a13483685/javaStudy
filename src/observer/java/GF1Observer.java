package observer.java;

public class GF1Observer implements observerJava{
    @Override
    public void update(String string) {
        System.out.println("get msg:"+string);
    }
}
