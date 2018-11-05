package thread.concurrent.SingleThreadPool;

public class Test {
    static class Passengers extends Thread{
        //机场安检类
        private final  FlightSecurity flightSecurity;

        //旅客的身份证
        private final String idCard;

        //登机牌
        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity,String idCard,String boardingPass){
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run() {
            while (true){
                flightSecurity.pass(boardingPass,idCard);
            }
        }
    }

    public static void main(String[] args){
        final FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity,"A123123213","A12321332").start();
        new Passengers(flightSecurity,"C123123213","C12321332").start();
        new Passengers(flightSecurity,"D123123213","D12321332").start();
    }
}
