package com.ning.springboot.test;

import java.util.*;

/**
 * 章节排序
 * Created by Ay on 2016/7/9.
 */
public class ChapterSortTest {

    public static void main(String[] args) {

        /** 从数据库加载数据 **/
        List<String> chapterList = getDataFromDB();
        /** 章节list转化为map **/
        Map<String,String> chapterMap =  listChangeToMap(chapterList);
        System.out.println(chapterMap);
        /** 获得章节号 **/
        List<String> chapterNum = getChapterNum(chapterMap);
        System.out.println(chapterNum);
        /** 章节号去除点 **/
        Map<Integer,String> chapterNumNoDot =  removeDot(chapterNum);
        System.out.println(chapterNumNoDot);

        /** 获取数字最大长度 **/
        int maxLength = getChapterNumMaxLength(chapterNumNoDot.keySet());
        /** 获取补0后的列表 **/
        List<String> fillZeroChapterNum = fillZero(maxLength,chapterNumNoDot);
        /** 排序 默认是升序，刚好是我们需要的**/
        Collections.sort(fillZeroChapterNum);
        /** 重组map对象**/
        List<String> sortChapterList =  getSortChapterMap(fillZeroChapterNum,chapterMap,chapterNumNoDot);
        /** 打印信息 **/
        if(sortChapterList != null){
            for(String key:sortChapterList){
                System.out.println(key);
            }
        }

    }

    /**
     * 获得排序后的map
     * @param fillZeroChapterNum
     * @param chapterMap
     * @return
     */
    public static List<String> getSortChapterMap(List<String> fillZeroChapterNum,Map<String,String> chapterMap,Map<Integer,String> chapterNotDot){
        if(null == fillZeroChapterNum || fillZeroChapterNum.size() == 0) return null;
        if(null == chapterMap) return null;
        List<String> sortChapterList = new ArrayList<>();
        for(String temp:fillZeroChapterNum){
            sortChapterList.add(chapterNotDot.get(Integer.parseInt(temp.replace("0", ""))) + " " + chapterMap.get(chapterNotDot.get(Integer.parseInt(temp.replace("0", "")))));
        }
        return sortChapterList;
    }

    /**
     * 补零操作
     * @return
     */
    public static List<String> fillZero(int maxLength,Map<Integer,String> chapterNumNoDot){
        if(null == chapterNumNoDot || chapterNumNoDot.size() ==0) return null;
        List<String> fillZeroList = new ArrayList<>();
        for(Integer key:chapterNumNoDot.keySet()){
            fillZeroList.add(key + getNeedZero(maxLength - (key + "").length()));
        }
        return fillZeroList;
    }

    /**
     * 获得需要0的个数
     * @param num
     * @return
     */
    public static String getNeedZero(int num){
        if(num <1) return "";
        StringBuffer sb = new StringBuffer();
        /** 拼凑需要的0 **/
        for(int i=0;i<num;i++){
            sb.append("0");
        }
        return sb.toString();
    }

    /**
     * 返回数组最大值
     * @param a
     * @return
     */
    public static int max(int[] a){
        // 返回数组最大值
        int x;
        int aa[]=new int[a.length];
        System.arraycopy(a,0,aa,0,a.length);
        x=aa[0];
        for(int i=1;i<aa.length;i++){
            if(aa[i]>x){
                x=aa[i];
            }
        }
        return x;
    }

    /**
     * 获得章节号最大长度
     * @param chapterNumNoDot
     * @return
     */
    public static int getChapterNumMaxLength(Set<Integer> chapterNumNoDot){
        if(null == chapterNumNoDot || chapterNumNoDot.size() == 0) return 0;
        Object[] chapterNumArr = chapterNumNoDot.toArray();
        int[] chapterNum = new int[chapterNumArr.length];
        for(int i=0;i<chapterNumArr.length;i++){
            chapterNum[i] = chapterNumArr[i].toString().length();
        }
        return max(chapterNum);
    }


    /**
     * 去除章节号中的点
     * @param chapterNumList
     * @return
     */
    public static Map<Integer,String> removeDot(List<String> chapterNumList){
        if(null == chapterNumList || chapterNumList.size() == 0) return null;
        Map<Integer,String> rmDotChapterNumMap = new HashMap<>();
        for(int i=0;i<chapterNumList.size();i++){
            /** 把点替换成空 **/
            rmDotChapterNumMap.put(Integer.parseInt(chapterNumList.get(i).replace(".","")),chapterNumList.get(i));
        }
        return rmDotChapterNumMap;
    }

    /**
     * 获取章节号
     * @param chapterMap
     * @return
     */
    public static List<String> getChapterNum(Map<String,String> chapterMap){
        if(null == chapterMap) return null;
        List<String> chapterNumList = new ArrayList<>();
        for(String chapterNum:chapterMap.keySet()){
            chapterNumList.add(chapterNum);
        }
        return chapterNumList;
    }

    /**
     * 把list转变为map
     * @param chapterList
     * @return
     */
    public static Map<String,String> listChangeToMap(List<String> chapterList){
        /** 存到map中 **/
        Map<String,String> chapterMap = new HashMap<>();
        if(null == chapterList || chapterList.size() == 0) return null;
        for(String chapter:chapterList){
            chapterMap.put(chapter.split(" ")[0], chapter.split(" ")[1]);
        }
        return chapterMap;
    }

    /**
     * 从数据库获取数据
     * @return
     */
    public static List<String> getDataFromDB(){
        List<String> chapterList = new ArrayList<>();
        chapterList.add("1.3.1 华丽新设计");
        chapterList.add("1.4 思想流派");
        chapterList.add("3.1 短小");
        chapterList.add("3.2 只做一件事");
        chapterList.add("2.11 别伴可爱");
        chapterList.add("4.4.12 注释掉的代码");
        chapterList.add("1.11 要有代码");
        chapterList.add("2.1 介绍");
        chapterList.add("8.5 使用尚不存在的代码");
        chapterList.add("5.3.1 水平方向上的区隔与靠近");
        return chapterList;
    }
}
