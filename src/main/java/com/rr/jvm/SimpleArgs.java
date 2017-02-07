package com.rr.jvm;

/**
 * Created by Limaoran on 2016/12/20.
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for(int i=0;i<args.length;i++){
            System.out.println("参数："+(i+1)+":"+args[i]);
        }
        // 可以在启动时，设定jvm参数：-Xmx256m
        System.out.println("-Xmx:"+Runtime.getRuntime().maxMemory()/1000/1000+"M");
    }
}
