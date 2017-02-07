package com.rr.algorithms.array;

import java.util.Random;

/**
 * 简单排序——冒泡排序、选择排序、插入排序
 * sort————@sortBubble、@sortSelection、@sortInsert
 * Created by Limaoran on 2016/9/16.
 */
public class ArraySimpleSort {
    private long [] arr ;
    private int length ;
    public ArraySimpleSort(int size){
        arr = new long[size];
        length = 0;
    }

    /**
     * 无序插入
     * @param value
     */
    public void insert(long value){
        arr[length] = value;
        length++;
    }
    public void display(){
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+(i!=length-1?",":""));
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    public void sortBubble(){
        int out,in ;
        long tempValue;
        int swapCount = 0,sortCount=0;
        for(out=length-1;out>1;out--){
            for(in=0;in<out;in++){
                sortCount++;
                if(arr[in]>arr[in+1]){
                    tempValue = arr[in];
                    arr[in] = arr[in+1];
                    arr[in+1] = tempValue;
                    swapCount++;
//                    swap(in,in+1);
                }
            }
        }
        System.out.println("冒泡排序，比较次数："+sortCount+"，交换次数："+swapCount);
    }

    /**
     * 选择排序
     */
    public void sortSelection(){
        int in,out,min;
        int swapCount =0,sortCount = 0;
        for(out=0;out<length-1;out++){
            min = out;
            for(in=out+1;in<length;in++){
                sortCount ++ ;
                if(arr[min] > arr[in]){
                    min = in;
                }
            }
            if(min!=out) {
                // swap
                swap(out, min);
                swapCount++;
            }
        }
        System.out.println("选择排序，比较次数："+sortCount+"，交换次数："+swapCount);
    }

    /**
     * 插入排序
     */
    public void sortInsert(){
        int in,out;
        long tempValue;
        for(out=1;out<length;out++){
            tempValue = arr[out];
            for(in=out;in>0 && arr[in-1]>tempValue ; in--){
                arr[in] = arr[in-1];
            }
            arr[in] = tempValue;
        }
    }


    protected void swap(int one,int two){
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    /**
     * 构建一个新的数组对象
     * @return
     */
    @Override
    public ArraySimpleSort clone() {
        ArraySimpleSort array = new ArraySimpleSort(length);
        for(int i=0;i<length;i++){
            array.arr[i] = arr[i];
        }
        array.length = length;
        return array;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int length = 50000;
        ArraySimpleSort arr = new ArraySimpleSort(length);

        for(int i=0;i<length;i++){
            arr.insert(random.nextInt(length+10));
        }
        ArraySimpleSort clone = arr.clone();
        ArraySimpleSort clone2 = arr.clone();

        arr.display();

        long startTime = System.currentTimeMillis();
        arr.sortBubble();
        long time1 = System.currentTimeMillis();
        clone.sortSelection();
        long time2 = System.currentTimeMillis();
        clone2.sortInsert();
        long time3 = System.currentTimeMillis();

        System.out.println("排序耗时：");
        System.out.println("\t冒泡排序耗时："+(time1-startTime)+"毫秒");
        System.out.println("\t选择排序耗时："+(time2-time1)+"毫秒");
        System.out.println("\t插入排序耗时："+(time3-time2)+"毫秒");

        arr.display();
        clone.display();
        clone2.display();
    }
}
