package thread;
//线程的死锁 ,都在等待对方来释放锁
class ThreadDeadLock {
    public static StringBuffer sb1 = new StringBuffer();
    public static StringBuffer sb2 = new StringBuffer();

    public static void main(String args[]){
        new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (sb1){
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb2.append("A");
                }

                synchronized (sb2){
                    sb1.append("B");
                }
                System.out.println(sb2);
                System.out.println(sb1);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (sb2){
                    sb1.append("C");
                }
                synchronized (sb1){
                    sb2.append("D");
                }
            }
        }.start();
    }

}

