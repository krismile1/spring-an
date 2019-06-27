package com.ning.springboot.test;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Create By : an
 * Time : 2018/12/27 17:57
 * Description :
 */
public class TestDate {

    /*
       Instant学习
    */
    @Test
    public void test01() {

        Instant now = Instant.now();
        System.out.println(now.toString());
        //毫秒
        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
        // 微秒
        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
        // 纳秒
        System.out.println(now.get(ChronoField.NANO_OF_SECOND));
        // 毫秒转Instant
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        // 2018-01-14T11:03:35.002
        System.out.println(localDateTime);

        System.out.println(System.currentTimeMillis());
    }

    /*
    LocalDate学习
     */
    @Test
    public void test02() {

        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

//日期加上1天
        LocalDate plusDay = now.plusDays(1);
        System.out.println(plusDay.toString());

//日期加上一周
        LocalDate plusWeek = now.plusWeeks(1);
        System.out.println(plusWeek.toString());

//计算当年前的第52天是几月几号
        System.out.println("今年的第52天是：" + now.withDayOfYear(52));

//字符串转日期
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor dateTempora = dateTimeFormatter.parse("2018-01-14");
        LocalDate date = LocalDate.from(dateTempora);
        System.out.println(date);

//格式化日期
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateStr = dateTimeFormatter1.format(now);
        System.out.println(dateStr);
    }

    @Test
    public void test03() {

        String s = "qwe";

        System.out.println(s == new String("qwe"));
        System.out.println(s.equals(new String("qwe")));
    }

}
