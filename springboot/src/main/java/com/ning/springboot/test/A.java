package com.ning.springboot.test;

import java.util.HashSet;
import java.util.Set;

public class A {
//       public int hashCode(){return 2;}
////       public static void main(String args[]){
////         Set set=new HashSet();
////         set.add(new A());
////         set.add(new A());
////         set.add(new A());
////         System.out.printlnln(set.size());
//
//    public static int i=1;
//    public static void main(String[] args){
//        new Thread(()->System.out.println((++i) +  "")).start();
//        new Thread(()->System.out.println((--i) +  "")).start();
//        System.out.println(i+ "");
////           }
//    }

    public static void test(String...strings){
        System.out.println(strings.length);
    }
    public static void main(String[] args){
//        test();
//        test(null);
//        test(null,null);

        String a,b;
        a = "cetc15";
        b = "cetc" + "15";
        System.out.println("1"+(a==b)+",a="+a+",b="+b + ",");//true
        b ="cetc"+"15";
        System.out.println("2"+(a==b)+",a="+a+",b="+b + ",");//true
        b ="cetc";
        b +="15";
        System.out.println("3"+(a==b)+",a="+a+",b="+b+",");//false
        b="cetc";
        b=b +"15";
        System.out.println("4"+(a==b)+",a="+a+",b="+b + ",");//false
        b=String.valueOf(a);
        System.out.println("5"+(a==b)+",a="+a+",b="+b+ ",");//true
        b=a.substring(0, a.length());
        System.out.println("6"+(a==b)+",a="+a+",b="+b+ ",");//true
        b=a.replace("cetc15s", "");
        System.out.println("7"+(a==b)+",a="+a+",b="+b + ",");//true
        b=a.replace("15","15");
        System.out.println("8"+(a==b)+",a="+a+",b="+b + ",");//false
        b=new StringBuilder(a).toString();
        System.out.println("9"+(a==b)+",a="+a+",b="+b);//false
    }
}