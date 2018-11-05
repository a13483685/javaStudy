package thread.concurrent.ReadAndWriteLock;

public class Test {
    private static String TAG = "This is a demo";
    public static void main(String[] args){

        final ShareDate shareDate = new ShareDate(50);
        for (int i =0;i<2;i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for (int inde = 0; inde < TAG.length(); inde++) {
                        char c = TAG.charAt(inde);
                        shareDate.write(c);
                        System.out.println(currentThread()+ "write "+c);
                    }
                }
            }.start();
        }


        for (int i =0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    while (true){
                        try {
                            System.out.println(currentThread()+"read"+new String(shareDate.read()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

        }
    }
}
