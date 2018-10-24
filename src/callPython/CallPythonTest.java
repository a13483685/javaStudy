package callPython;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

public class CallPythonTest {
    @Test
    public void test(){
        Process proc = null;
        byte[] b = new byte[1024];
        int read =0;
        try {
            proc = Runtime.getRuntime().exec("python F:\\work\\pythonTest\\ConsoleThread.py");
            Timer timer = new Timer();
            OutputStream os = proc.getOutputStream();
            InputStream errorStream = proc.getInputStream();
            while ((read = errorStream.read(b))!=-1){
                System.out.println(new String(b,0,read));
            }
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        os.write(1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },1000);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
