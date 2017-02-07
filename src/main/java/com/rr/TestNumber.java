package com.rr;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Limaoran on 2016/5/10.
 */
public class TestNumber {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(Math.pow(2,500)));
        int index = 0;
        System.out.println(++index+"："+"Boolean类型的值："+Boolean.TRUE+"，"+Boolean.FALSE);
        System.out.println(++index+"："+"Byte最小值和最大值："+Byte.MIN_VALUE+"，"+Byte.MAX_VALUE);
        System.out.println(++index+"："+"Char最小值和最大值："+Character.MIN_VALUE+"，"+Character.MAX_VALUE);
        System.out.println(++index+"："+"Short最小值和最大值："+Short.MIN_VALUE+"，"+Short.MAX_VALUE);
        System.out.println(++index+"："+"Int最小值和最大值："+Integer.MIN_VALUE+"，"+Integer.MAX_VALUE);
        System.out.println(++index+"："+"Long最小值和最大值："+Long.MIN_VALUE+"，"+Long.MAX_VALUE);
        System.out.println(++index+"："+"Float最小值和最大值："+Float.MIN_VALUE+"，"+Float.MAX_VALUE);
        System.out.println(++index+"："+"Double最小值和最大值："+Double.MIN_VALUE+"，"+Double.MAX_VALUE);
    }
}
