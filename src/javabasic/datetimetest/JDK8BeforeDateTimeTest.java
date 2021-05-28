package javabasic.datetimetest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 */
public class JDK8BeforeDateTimeTest {
    // *************************************JDK8 之前日期时间 API*************************************
    /**
     * System
     * 单位为 ms - 时间戳
     */
    @Test
    public void test1() {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
    }

    /**
     * java.util.Date - 平时使用
     * java.sql.Date - 和数据库交互时使用
     */
    @Test
    public void test2() {
        // java.util.Date
        Date date = new Date();
        System.out.println(date.toString()); // Thu May 27 18:17:44 CST 2021
        System.out.println(date.getTime()); // 时间戳-1622110752061
        System.out.println(new Date(1622110752061L));
        System.out.println(new java.sql.Date(1622110752061L));
        // 将 java.util.Date 对象转换为 java.sql.Date 对象
        // 情况一：
//        Date date1 = new java.sql.Date(1622110752061L);
//        java.sql.Date date2 = (java.sql.Date)date1;
        // 情况二：
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
    }

    /**
     * SimpleDateFormat
     * 格式化：日期 -> 字符串
     * 解析：字符串 -> 日期
     * [class SimpleDateFormat](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)
     */
    @Test
    public void test3() {
        // 使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 格式化
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);
        // 解析
        String str = "2021-05-27 22:10:13";
        SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf_1.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习： 字符串 2019-03-26 转换为 java.sql.Date
     */
    @Test
    public void test4() throws ParseException {
       String birth = "2019-03-26";
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date = sdf.parse(birth);
       java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /**
     * 三天打渔两天晒网
     * 1999-01-01
     * 到
     * 2021-05-27
     * 有几天打渔，几天晒网？
     * 总天数 %5 == 1,2,3 打渔
     * 总天数 %5 == 4,0 晒网
     * 总天数的计算：计算毫秒数，然后相减得差值，再转换得到总天数
     */
    @Test
    public void test5() throws ParseException {
        String start = "1999-01-01";
        String end = "2021-05-27";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 起始毫秒
        Date date = sdf.parse(start);
        Long time1 = date.getTime();
        // 终止毫秒
        date = sdf.parse(end);
        Long time2 = date.getTime();
        // 差值
        Long sub = time2-time1;

        long day = (sub / 1000 / 3600 / 24)+1;
        System.out.println(day);

        int modula = (int) day % 5;
        int work = 0;
        int rest = 0;
        if (modula == 1 || modula == 2 || modula == 3) {
            System.out.println("打渔");
        } else {
            System.out.println("晒网");
        }

    }

    /**
     * Calender 类使用
     * 获取月份时：一月为0计算，以此类推
     * 获取星期时：周日是 1，以此类推
     */
    @Test
    public void test6(){
        // 方式一： 创建子类（GregorianCalender）实例
        // 方式二： 调用静态方法
        Calendar calendar = Calendar.getInstance();

        // 2021年05月28日14:42:42 - 星期五
        // 常用方法
        // get()
        System.out.println("************************************");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 28
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 6
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 148

        // set()
        System.out.println("************************************");
        calendar.set(Calendar.DAY_OF_MONTH,26);// 26
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // add()
        System.out.println("************************************");
        calendar.add(Calendar.DAY_OF_MONTH, -3); // 23
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // getTime()
        System.out.println("************************************");
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime()
        System.out.println("************************************");
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 28

    }

}
