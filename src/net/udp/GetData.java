package net.udp;

import java.io.UnsupportedEncodingException;

public class GetData implements IUDPListener{
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
