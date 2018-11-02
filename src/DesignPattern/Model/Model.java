package DesignPattern.Model;

/**
 * 模板设计模式，Thread类中的 run方法
 */
public class Model {
    public void printMsg(String msg){
        System.out.println("##################################\n");
        warpPrint(msg);
        System.out.println("##################################");
    }
    protected void warpPrint(String msg){

    }

    public static void main(String args[]){
       Model model= new Model(){
            @Override
            protected void warpPrint(String msg) {
                System.out.println(msg);
                super.warpPrint(msg);
            }
        };
       model.printMsg("hello\n");
    }
}
