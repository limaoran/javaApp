package com.rr.algorithms.array;

/**
 * 基于过程的数组处理
 * Created by Limaoran on 2016/9/16.
 */
public class ArrayApp {
    public static void main(String[] args) {
        long [] arr ; // 声明数组
        arr = new long[100];

        arr[0] = 77;
        arr[1] = 44;
        arr[2] = 55;
        arr[3] = 66;
        arr[4] = 99;
        arr[5] = 88;
        arr[6] = 33;
        arr[7] = 22;
        arr[8] = 11;
        arr[9] = 0;

        int elems = 10;
        long searchKey;
        // 显示所有元素
        for(int i=0;i<elems;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        // 查找66
        searchKey = 66;
        int n = 0;
        for(n=0;n<elems;n++){
            if(arr[n] == searchKey){
                break;
            }
        }
        if(n == elems){
            System.out.println("没有找到数值："+searchKey);
        }else{
            System.out.println("找到了数值："+searchKey);
        }
        // 删除55
        for(n=0;n<elems;n++){
            if(arr[n]==searchKey)break;
        }
        for(int k=n;k<elems-1;k++){
            arr[k] = arr[k+1];
        }
        elems -- ;
        // 显示全部
        for(int i=0;i<elems;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
