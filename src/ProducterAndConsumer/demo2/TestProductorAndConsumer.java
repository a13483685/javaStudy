package ProducterAndConsumer.demo2;

public class TestProductorAndConsumer {
    public static void main(String args[]){
        Clert clert = new Clert();
        Productor productor = new Productor(clert);
        Consumer consumer = new Consumer(clert);
        new Thread(productor,"生产者线程").start();
        new Thread(consumer,"消费者线程").start();

    }

}

class Clert{
     private int num = 0;
     public synchronized void get(){
         if(num>=10){
             System.out.println("货物已满");
             try {
                 this.wait();
             } catch (InterruptedException e) {
             }
         }else {
             System.out.println(Thread.currentThread().getName()+":"+ ++num);
            this.notify();
         }
     }

     public synchronized void sale(){
         if(num<=0){
             System.out.println("缺货");
             try {
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }else {
             System.out.println(Thread.currentThread().getName()+":"+ --num);
             this.notify();
         }
     }
}

class Productor implements Runnable{
    Clert clert = null;
    public Productor(Clert clert){
        this.clert = clert;
    }

    @Override
    public void run() {
        for (int i = 0;i<40;i++)
        this.clert.get();
    }
}

class Consumer implements Runnable{
    Clert clert = null;
    public Consumer(Clert clert){
        this.clert = clert;
    }

    @Override
    public void run() {
        for (int i = 0;i<40;i++)
            this.clert.sale();
    }
}
