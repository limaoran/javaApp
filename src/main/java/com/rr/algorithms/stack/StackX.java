package com.rr.algorithms.stack;

/**
 * 栈的实现
 * Created by Limaoran on 2016/9/21.
 */
public class StackX {
    private long [] stackArray;
    private int maxSize;
    private int top;

    public StackX(int maxSize){
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    /**
     * 添加数据
     * @param value
     */
    public void push(long value){
        top++;
        stackArray[top] = value;
    }

    /**
     * 查看
     * @return
     */
    public long peek(){
        return stackArray[top];
    }

    /**
     * 查看并删除
     * @return
     */
    public long pop(){
        return stackArray[top--]; //先取值，后-1
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return top<0;
    }

    /**
     * 是否已满
     * @return
     */
    public boolean isFull(){
        return top==(maxSize-1);
    }

    public static void main(String[] args) {
        StackX stack = new StackX(10);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(7);
        stack.push(8);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
