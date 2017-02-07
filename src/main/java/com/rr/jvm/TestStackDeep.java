package com.rr.jvm;

/**
 * 查看栈的深度
 *
 * 执行前，添加jvm参数：-Xss128k
 *
 * Created by Limaoran on 2016/12/20.
 */
public class TestStackDeep {
    static int count = 0;
    static void recursion(){
        count++;
        recursion();
    }
    public static void main(String[] args) {
        try {
            recursion();
        }finally {
            System.out.println("count:"+count);
        }
    }
}
