package com.rr.jvm;

/**
 * 打印-10的补码
 * Created by Limaoran on 2016/12/20.
 */
public class Test01 {
    public static void main(String[] args) {
        int a = -10;
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80_000_000 >>> i) >>> (31 - i);
            System.out.print(t);
        }

        float a2 = -5;
        // 获取单精度浮点数的IEEE 754表示
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(a2)));
    }
}
