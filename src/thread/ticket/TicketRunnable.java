package thread.ticket;

/**
 * 如何解决线程安全问题
 * 必须让一个线程操作共享数据完毕之后，其他线程才有机会参与共享数据操作
 * java如何实现线程的安全：线程同步机制
 *      方式一：同步代码块
<<<<<<< HEAD
 *      1共享数据：多个线程共同操作的一个数据（变量）
 *      2同步监听器：由一个类的对象来充当。哪个线程获取此监听器，谁就执行大括号里被同步的代码，也叫作锁
 *      方式二：同步方法
 */
class SaleTickets implements Runnable{
    int ticket =100;//共享数据
    Object obj = new Object();//同步监听器，可以是任意一个类
    @Override
    public void run() {

        synchronized (obj){//也可以用this ,这个对象得是唯一的 如果使用继承至thread来实现线程 因为代表多个对象 ，这个锁代表的对象只能是一个 同一时刻只能有一个对象作为锁
            while (ticket>0){
                try {
                    Thread.currentThread().sleep(100);//休眠 线程会切换成就绪状态，时间过了之后才会再次运行 这时候要是别的线程操作的话，就会导致共享数据安全问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket -- ;
                System.out.println("remain tickets num is :"+ticket);
            }
        }

    }
}
public class TicketRunnable{
//    SaleTickets saleTickets = new SaleTickets();
//    SaleTickets thread = new SaleTickets(saleTickets);
    public static void main(String args[]){
        SaleTickets saleTickets = new SaleTickets();
        Thread thread1 = new Thread(saleTickets);
        Thread thread2 = new Thread(saleTickets);
        Thread thread3 = new Thread(saleTickets);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


