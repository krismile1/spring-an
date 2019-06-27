package com.ning.springboot.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Create By : an
 * Time : 2019/2/20 10:41
 * Description :
 */
public class Test2 {

    /**
     * 输出 ：i=0 i=1 i=2 i=3
     */
    @Test
    public void testBreak() {
        int stop = 4;
        for (int i = 0; i < 10; i++) {

            if (i == stop) {

                // 当i等于4的时候循环退出
                break;
            }
            System.out.print(" i=" + i);
        }
    }

    /**
     * 输出：i=0 i=1 i=2 i=3 i=5 i=6 i=7 i=8 i=9
     */
    @Test
    public void testContinue() {
        int stop = 4;
        for (int i = 0; i < 10; i++) {

            if (i == stop) {

                // 终止i等于4的这次循环,跳出循环体中continue语句下面未执行的循环，开始下一次循环过程。
                continue;
            }
            System.out.print(" i=" + i);
        }
    }


    /*
    使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。（考察高效率，解决产生冲突的问题

    方案：
    以100为例，1000W时将value值更改即可，选取1-100范围方便时输出检验是否正确。
    先构建一个value大小的数组，按下标存储1-value范围的值。
    有了这样一个数组之后，用random.nextInt(value) 每次随机生成[0,value)范围的值，
    用count+value 作为下标交换count+value 和count位置的两个数，比如交换 list[0+5] 和list[0]。
    下一次count++，交换某个位置和list[1],这样相当于随机选取某个位置的数，逐一放在数组的第0个位置、第1个位置。
    注意：count+value不能超过原本value的值，每次count++都要value--。
     */
    @Test
    public void generatorRandom() {
        Random random = new Random();
        long start = System.currentTimeMillis();

        int value = 100;
        //使用数组速度更快
        int[] list = new int[value];

        for (int j = 0; j < value; ++j) {
            list[j] = j+1;
        }

        int index = 0;
        int count = 0;
        int tmp = 0;
        while (value > 0) {
            index = random.nextInt(value);
            //System.out.println(list[count + index]);
            tmp = list[count + index];
            list[count + index] = list[count];
            list[count] = tmp;
            ++count;
            --value;
        }

        long end = System.currentTimeMillis();

        //----验证是否正确
        Arrays.sort(list);
        int i = 0, size = list.length;
        for (; i < size; ++i) {
            System.out.println(list[i]);
            if (list[i] != (i + 1))
                System.out.println(i + "error" + list[i]);
        }
        //----验证是否正确

        System.out.println("creat4------");
        System.out.println("执行耗时 : " + (end - start) / 1000f + " 秒 ");
        System.out.println("完了，集合大小为" + list.length);

    }
}
