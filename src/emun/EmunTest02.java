package emun;

public class EmunTest02 {
    public static void main(String string[]){
        //类的对象是确定的
        System.out.println(Season1.AUTUM.toString());
        System.out.println(Season1.SPRING.toString());
        System.out.println(Season1.SUMMER.toString());
        System.out.println(Season1.WINTER.toString());
    }
}

/**
 * 枚举类 java1.5之后枚举类的使用方法
 */
enum  Season1{
    //public static final Season类型
    SPRING ("spring","春"),//对象（属性）
    SUMMER("summer","夏"),
    AUTUM("autum","秋"),
    WINTER("winter","冬");
    private final String Name;
    private final String Desc;
    private Season1 (String name, String desc) {
        Name = name;
        Desc = desc;
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Desc;
    }

    /**
     * 创建枚举对象
     */


    @Override
    public String toString() {
        return "Season{" +
                "Name='" + Name + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
