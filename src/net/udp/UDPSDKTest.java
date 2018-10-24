package net.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UDPSDKTest {
    public static void main(String[] arg){
        GetDataTest getData = new GetDataTest();
        try {
            UDPClientAPI api = new UDPClientAPI("192.168.60.54", 9998,9999, getData);
            api.sendData("112".getBytes());
            api.simpleWaitingRead(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class GetDataTest implements IUDPListener{
        @Override
        public void onReceiveData(byte[] vaild_b) {
            try {
                String s = new String(vaild_b, "UTF-8");
                System.out.println("get data is :"+s);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
