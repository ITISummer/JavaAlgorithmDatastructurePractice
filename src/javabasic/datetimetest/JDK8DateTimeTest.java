package javabasic.datetimetest;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * JDK8 中日期时间 API 测试
 */
public class JDK8DateTimeTest {

    // *************************************JDK8及之后日期时间 API*************************************
    /**
     * 偏移量问题
     */
    @Test
    public void test1() {
        // 偏移量 - 表示 2020-09-08
        Date date = new Date(2020-1900,9-1,8);
        System.out.println(date); //Tue Sep 08 00:00:00 CST 2020
    }

    /**
     * LocalDate
     * LocalTime
     * LocalDateTime - 使用频率更高
     */
    @Test
    public void test2() {
        //now() 获取当前日期，时间
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();

        System.out.println("************************************");
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);

        System.out.println("************************************");
        // of() 设置指定日期时间，不需要设置偏移量
        LocalDateTime ldtOf = LocalDateTime.of(2021, 5, 21, 13, 14, 52, 0);
        System.out.println(ldtOf);

        // getXxx()
        System.out.println("************************************");
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getDayOfYear());

        // with()
        System.out.println("************************************");
        LocalDateTime newLdt = ldt.withDayOfMonth(3);
        System.out.println(newLdt);
        System.out.println(ldt);
    }

    /**
     * Instant 的使用
     * 类似于 java.util.Date
     */
    @Test
    public void test3(){
        // 获取本初子午线时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 正确的当前时间

        // 获取距离 1970-01-01 00：00：00 到当前的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过毫秒数获取日期时间 - 本初子午线
        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter 类似于 SimpleDateFormat
     */
    @Test
    public void test4(){
        // 方式一： ISO_LOCAL_DATE_TIME, ISO_DATE, ISO_TIME - 使用较少
        // 格式化： 日期 -> 字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();
        String str1 = formatter.format(ldt);
        System.out.println(ldt); //2021-05-28T15:54:23.280

        System.out.println(str1); //2021-05-28T15:54:23.280
        // 解析: 字符串 -> 日期
        TemporalAccessor parser = formatter.parse("2021-05-28T15:47:27.549");
        System.out.println(parser); //{},ISO resolved to 2021-05-28T15:47:27.549

        System.out.println("***************************************");
        // 方式二：本地化相关格式。如： ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // 格式化
        String str2 = dtf.format(ldt);
        System.out.println(str2); //28/05/21 3:54 PM

        System.out.println("***************************************");
        // 方式三： 自定义格式： ofPatter("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str3 = formatter1.format(LocalDateTime.now());
        System.out.println(str3); //2021-05-28 04:00:22

        // 解析 2021-05-28 04:00:22
        TemporalAccessor accessor = formatter1.parse("2021-05-28 04:00:22");
        System.out.println(accessor);
    }

}
