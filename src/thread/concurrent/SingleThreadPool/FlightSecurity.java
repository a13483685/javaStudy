package thread.concurrent.SingleThreadPool;

public class FlightSecurity {
    private int count = 0;
    private String boardingPass = "null";
    private String idCard = "null";

    /**
     * 如果不加关键字synchronized 会走System.out.println("exception---------------------"+toString());
     * 因为在执行check（）之前，可能cpu的控制权被切换到别的线程
     * @param boardingPass
     * @param idCard
     */
    public synchronized void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
    }

    private void check() {
        if(boardingPass.charAt(0)!=idCard.charAt(0)){
            System.out.println("exception---------------------"+toString());
        }
    }

    @Override
    public String toString() {
        return "The "+ count+"  passengers,boarding ["+ boardingPass+"[,idCard"+idCard +"]";
    }
}
