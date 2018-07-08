package DesignPattern;
//单例模式，如果不用同步代码块 那么有可能出现线程安全问题，同一个时刻，只会有一个对象呗访问
class Singleton {
    private static Singleton singleton = null;
    private Singleton(){

    }
    public static Singleton getInstance(){
        synchronized (Singleton.class)
        {
            if (singleton == null){
                singleton = new Singleton();
            }
        }

        return singleton;
    }

}

class TestSingleton{
    public static void main(String args[]){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        if(instance1 == instance2)
        {
            System.out.println("is true");
        }
    }
}
