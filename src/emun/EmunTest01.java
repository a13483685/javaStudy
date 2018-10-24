package emun;

public class EmunTest01 {
    public static void main(String string[]){
        //类的对象是确定的
        System.out.println(Season.AUTUM.toString());
        System.out.println(Season.SPRING.toString());
        System.out.println(Season.SUMMER.toString());
        System.out.println(Season.WINTER.toString());
    }
}

/**
 * 枚举类 java1.5之前没有枚举    自定义枚举类
 */
class Season{
    private final String Name;
    private final String Desc;
    private Season(String name, String desc) {
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
    public static final Season SPRING = new Season("spring","春");
    public static final Season SUMMER = new Season("summer","夏");
    public static final Season AUTUM = new Season("autum","秋");
    public static final Season WINTER = new Season("winter","冬");

    @Override
    public String toString() {
        return "Season{" +
                "Name='" + Name + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
