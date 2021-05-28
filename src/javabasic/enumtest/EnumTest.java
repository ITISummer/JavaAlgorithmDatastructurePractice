package javabasic.enumtest;

import org.junit.Test;

class Season {
    private final String seasonName;

    private Season(String seasonName){
        this.seasonName = seasonName;
    }

    public static final Season SPRING = new Season("春天");
    public static final Season SUMMER = new Season("夏天");
    public static final Season AUTUMN = new Season("秋天");
    public static final Season WINTER = new Season("冬天");

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }
}
/**
 * 枚举类的使用
 * 类的对象只有有限个
 * 当需要定义一组常量时，强烈建议使用枚举类
 * 如果枚举类只有一个对象，则可以作为单例模式的实现方式
 * 如何定义枚举类：
 * 1. jdk5 之前，自定义枚举类
 * 2. jdk5 之后，使用 enum 关键字
 */
public class EnumTest {
    /**
     * 自定义枚举类
     */
    @Test
    public void test1(){
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

    /**
     * 使用 enum 关键字定义枚举类
     * 定义的枚举类默认继承 Enum
     *
     */
    @Test
    public void test2(){
        Season1 summer = Season1.SUMMER;
        System.out.println(summer); //SUMMER
//        System.out.println(Season1.class.getSuperclass()); //Enum
        System.out.println("*****************************");
        Season1[] seasons = Season1.values();
        for (Season1 season : seasons) {
            System.out.println(season.getSeasonName());
        }
        System.out.println("*****************************");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

/**
 * [enum 关键字定义枚举类](https://www.bilibili.com/video/BV1Kb411W75N?p=500&spm_id_from=pageDriver)
 */
enum Season1 {
//    public static final Season1 SPRING = new Season1("春天");
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    private final String seasonName;

    private Season1(String seasonName){
        this.seasonName = seasonName;
    }


    public String getSeasonName() {
        return seasonName;
    }
// 一般情况下不重写
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                '}';
//    }
}
