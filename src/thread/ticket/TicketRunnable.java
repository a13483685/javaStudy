package thread.ticket;

/**
 * ��ν���̰߳�ȫ����
 * ������һ���̲߳��������������֮�������̲߳��л�����빲�����ݲ���
 * java���ʵ���̵߳İ�ȫ���߳�ͬ������
 *      ��ʽһ��ͬ�������
<<<<<<< HEAD
 *      1�������ݣ�����̹߳�ͬ������һ�����ݣ�������
 *      2ͬ������������һ����Ķ������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ�д������ﱻͬ���Ĵ��룬Ҳ������
 *      ��ʽ����ͬ������
 */
class SaleTickets implements Runnable{
    int ticket =100;//��������
    Object obj = new Object();//ͬ��������������������һ����
    @Override
    public void run() {

        synchronized (obj){//Ҳ������this ,����������Ψһ�� ���ʹ�ü̳���thread��ʵ���߳� ��Ϊ���������� �����������Ķ���ֻ����һ�� ͬһʱ��ֻ����һ��������Ϊ��
            while (ticket>0){
                try {
                    Thread.currentThread().sleep(100);//���� �̻߳��л��ɾ���״̬��ʱ�����֮��Ż��ٴ����� ��ʱ��Ҫ�Ǳ���̲߳����Ļ����ͻᵼ�¹������ݰ�ȫ����
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


