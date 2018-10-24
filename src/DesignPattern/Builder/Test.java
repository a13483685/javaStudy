package DesignPattern.Builder;

public class Test {
    public static void main(String[] args){
        //构造器
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);
        director.Construct("华硕","shape");
        System.out.println("computer info is :"+builder.create().toString());
    }
}
