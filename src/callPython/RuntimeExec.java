package callPython;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class RuntimeExec {
    public final static String cmd1 = "python --version";
//    public final static String cmd1 = "python F:\\work\\pythonTest\\ConsoleThread.py";
    private Process proc;
    private static int key;

    public void runtimeExec() {
        try {
            proc = Runtime.getRuntime().exec(new String[]{"cmd", "/c", cmd1});
            if(proc == null){
                System.out.println("python run failed!");
            }
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
//            StreamGobbler inputString = new StreamGobbler(proc.getInputStream(), "INPUT");
            StreamOut so = new StreamOut(proc.getOutputStream(),"OUTPUT");
            errorGobbler.start();
//            inputString.start();
            so.start();
            if (proc.waitFor() != 0) {
                System.out.println("执行\"" + cmd1 + "\"时返回值=" + proc.exitValue());
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class StreamOut extends Thread {
        OutputStream os;
        String type;
        StreamOut(OutputStream os,String type){
            this.os = os;
            this.type = type;
        }

        @Override
        public void run() {
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            try {
                bufferedWriter.write(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    class StreamGobbler extends Thread {
        InputStream is;
        String type;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()){
                    key = Integer.valueOf(sc.next());
                    System.out.println("msg is :"+ key);
                }
            }
        }.start();
        RuntimeExec rt = new RuntimeExec();
        rt.runtimeExec();
    }
}

