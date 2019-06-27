package com.ning.springboot.test;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * Create By : an
 * Time : 2018/10/30 15:01
 * Description :
 */
public class Test1 {

    @Test
    public void test01() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "我是String");
        System.out.println(list.get(1));
    }


    @Test
    public void test02() {
//        double v = Double.parseDouble("教育");
//        System.out.println(v);

//        Map map = new HashMap();
//        map.put("key", "");
//        map.get("key1").toString();

        String o1 = "1.22.3";
        String o2 = "1.22";

        String[] c1 = o1.split(".");
//        char[] c2 = o2.toCharArray();

        for (String s : c1){
            System.out.println(s);
        }
//        System.out.println(c1::toString);
    }

    @Test
    public void test03() {
//        String s = "hello";
//        String t = "hello";
//        char c[] = {'h', 'e', 'l', 'l', 'o'};
//
//        System.out.println(s.equals(t));
//        System.out.println(t.equals(c));
//        System.out.println(c);
//        System.out.println(s == t);
//        System.out.println(t.equals(new String("hello")));


        String[] snArr={"1.3","10.1.2","5","3.14","1.2.1.1","1.11"};

//        Arrays.sort(snArr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                char[] c1 = o1.toCharArray();
//                char[] c2 = o2.toCharArray();
//
//
//                return c1-c2;
//            }
//        });

        for(int i=0;i<snArr.length;i++)
            System.out.print(snArr[i]+"  ");
        }

    @Test
    public void test04() {
        String s = "1.2.3.4";

        String[] strarr = s.split("\\.");
        for (String a : strarr){
            System.out.println(a);
        }
    }

    @Test
    public void test05() {
//        List list = new ArrayList();
//        System.out.println(list);
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal(1);
        System.out.println(b.compareTo(a) < 0);
    }


}
