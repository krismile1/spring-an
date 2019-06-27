package com.ning.springboot.test;

import com.ning.springboot.aop.MathCalculator;
import com.ning.springboot.config.MainConfigOfAop;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create By : an
 * Time : 2018/11/23 17:30
 * Description :
 */
public class Test_Aop {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(2, 1);

        applicationContext.close();

    }

}
