package com.rr.algorithms.graph;

/**
 * 实现深度优先搜索使用的栈
 * Created by Limaoran on 2016/9/19.
 */
public class StackX {
    private final int SIZE = 20;
    private int [] st;
    private int top;
    public StackX(){
        st = new int[SIZE];
        top = -1;
    }
    public void push(int value){
        top ++;
        st[top] = value;
    }
    public int pop(){
        return st[top -- ]; //先返回，后--
    }

    /**
     * 只返回，不删除
     * @return
     */
    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return top < 0 ;
    }
}
