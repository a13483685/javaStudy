package DesignPattern.Singleton;
//����ģʽ���������ͬ������� ��ô�п��ܳ����̰߳�ȫ���⣬ͬһ��ʱ�̣�ֻ����һ�������·���
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
