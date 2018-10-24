package callPython;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class test_1 {
    
    public static void main(String[] args) {
        try {
            final String cmd1 = "python ";
            String[] args1 = new String[] { "cmd", "/c", cmd1};
           Process pr=Runtime.getRuntime().exec(args1);
           BufferedReader in = new BufferedReader(new InputStreamReader(
             pr.getInputStream()));
           String line;
           while ((line = in.readLine()) != null) {
            System.out.println(line);
           }
           in.close();
           pr.waitFor();
           System.out.println("end");
          } 
        catch (Exception e) {
           e.printStackTrace();
          }
        }
    private static String getPara(String string) {
        // TODO Auto-generated method stub
        return null;
    }


}