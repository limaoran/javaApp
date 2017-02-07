package com.rr.algorithms.array;

import java.util.Random;

/**
 * 有序数组和二分查找实现
 * Created by Limaoran on 2016/9/16.
 */
public class OrderArray {

    private long [] arr ;
    private int length = 0 ;
    public OrderArray(int size){
        arr = new long[size];
    }

    /**
     * 查看大小
     * @return 元素个数
     */
    public int size(){
        return length;
    }

    /**
     * 添加数据项（线性查找，添加）
     * @param value
     */
    public void insert(long value){
        int index;
        for(index=0;index<length;index++){
            if(arr[index]>value){
                break;
            }
        }
        for(int i=length;i>index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = value;
        length++;
    }

    /**
     * 使用二分查找插入
     * @param value
     */
    public void insert2(long value){
        int lowerBound = 0;
        int upperBound = length-1;
        int currentIndex = 0;
        int insertIndex = 0;
        while(true){
            currentIndex = (lowerBound+upperBound)/2;
            if(lowerBound > upperBound){
                insertIndex = lowerBound;
                break;
            }else if(arr[currentIndex]<value){    //向后继续
                lowerBound = currentIndex+1;
            }else if(arr[currentIndex]>value){ //向前继续
                upperBound = currentIndex-1;
            }else{ // ==
                insertIndex = currentIndex;
                break;
            }
        }
        for(int i=length;i>insertIndex;i--){
            arr[i] = arr[i-1];
        }
        arr[insertIndex] = value;
        length++;
    }

    /**
     * 二分查找方法
     * @param value
     * @return 没有找到，返回-1
     */
    public int find(long value){
        int lowerBound = 0;         //最小索引
        int upperBound = length-1;  //最大索引
        int currentIndex ;
        int count = 0;
        while(true){
            currentIndex = ( lowerBound + upperBound ) /2 ;
            if(arr[currentIndex]==value) {
                return currentIndex;
            }else if(lowerBound > upperBound){  //没有找到
                return -1;
            }else { //继续找
                if(arr[currentIndex]<value) {    //往后面查
                    lowerBound = currentIndex + 1;    //改变最小索引
                }else {
//                }else if(arr[currentIndex]>value){  //往前面查
                    upperBound = currentIndex-1;    //改变最大索引
                }
            }
            count++;
            System.out.println("查找次数：第"+count+"次");
        }
    }

    /**
     * 删除数据项（二分查找）
     * @param value
     */
    public boolean delete(long value){
        int result = find(value) ;
        if(result==-1) {
            return false;
        }
        // 移动元素
        for(int i=result;i<length-1;i++){
            arr[i] = arr[i+1];
        }
        length--;
        return true;
    }

    /**
     * 显示数据项
     */
    public void display(){
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+(i!=length-1?",":""));
        }
        System.out.println();
    }

    public long getValue(int index){
        return arr[index];
    }

    public static void main(String[] args) {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        int length = 10000;
        OrderArray arr = new OrderArray(length);
        for(int i=0;i<length;i++) {
//            arr.insert(random.nextInt(length));
            arr.insert2(random.nextInt(length));
        }
//        arr.display();
        arr.delete(arr.getValue(3));
        arr.delete(arr.getValue(4));
        arr.delete(arr.getValue(5));
        arr.delete(arr.getValue(6));
//        arr.display();
        System.out.println("数组当前长度："+arr.size());

        long endTime = System.currentTimeMillis();
        System.out.println("时间消耗："+(endTime-startTime)+"毫秒！");
    }
}
