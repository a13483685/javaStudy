package thread.ticket;
//多线程使用的demo
class Window extends Thread{
    public static int i = 300;//此处要用到static 因为都要访问
    @Override
    public void run() {
        super.run();
        while (i>0){
            i--;
            System.out.println("remian tickets num is :"+i);
        }
    }
}

public class TicketThread {

    public static void main(String str[]){
        Window win1 = new Window();
        Window win2 = new Window();
        Window win3 = new Window();
        win1.start();
        win2.start();
        win3.start();
    }
}
