package com.rr.algorithms.array;

/**
 * 简单数组封装
 * Created by Limaoran on 2016/9/16.
 */
public class LowArray {
    private long [] arr ;

    public LowArray(int size) {
        arr = new long[size];
    }
    public void setElem(int index , long value){
        arr[index] = value;
    }
    public long getElem(int index){
        return arr[index];
    }

    public static void main(String[] args) {
        LowArray arr = new LowArray(100);

        arr.setElem(0,77);
        arr.setElem(1,44);
        arr.setElem(2,55);
        arr.setElem(3,66);
        arr.setElem(4,99);
        arr.setElem(5,88);
        arr.setElem(6,33);
        arr.setElem(7,22);
        arr.setElem(8,11);
        arr.setElem(9,00);

        int elems = 10;
        long searchKey;
        // 显示所有元素
        for(int i=0;i<elems;i++){
            System.out.print(arr.getElem(i)+" ");
        }
        System.out.println();

        // 查找66
        searchKey = 66;
        int n = 0;
        for(n=0;n<elems;n++){
            if(arr.getElem(n) == searchKey){
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
            if(arr.getElem(n)==searchKey)break;
        }
        for(int k=n;k<elems-1;k++){
            arr.setElem(k, arr.getElem(k+1) );
        }
        elems -- ;
        // 显示全部
        for(int i=0;i<elems;i++){
            System.out.print(arr.getElem(i)+" ");
        }
        System.out.println();
    }
}
