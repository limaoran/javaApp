package com.rr.algorithms.array;

/**
 * 高级数组封装
 * Created by Limaoran on 2016/9/16.
 */
public class HighArray {
    private long [] arr ;
    private int length;
    public HighArray(int max){
        arr = new long[max];
        length = 0;
    }

    /**
     * 查找指定的项
     * @param searchValue
     * @return
     */
    public boolean find(long searchValue){
        for(int i = 0; i< length; i++){
            if(searchValue == arr[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素
     * @param searchValue
     * @return 没有找到，返回-1
     */
    public int findIndex(long searchValue){
        for(int i = 0; i< length; i++){
            if(searchValue == arr[i]){
                return i;
            }
        }
        return -1;
    }
    public void insert(long value){
        arr[length] = value ;
        length++;
    }
    public boolean delete(long value){
        int result = findIndex(value);
        if(result<0){
            return false;
        }else{
            //找到了，执行删除
            for(int i = result; i< length -1; i++){
                arr[i] = arr[i+1];
            }
            // 把最后面那个清空
            arr[length -1] = 0;

            length-- ;
            return true;
        }
    }
    public void display(){
        for(int i = 0; i< length; i++){
            System.out.print(arr[i] + ( i!=length-1?",":"" ) );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(100);

        arr.insert(77);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);
        arr.insert(99);
        arr.insert(88);
        arr.insert(33);
        arr.insert(22);
        arr.insert(00);
        arr.insert(11);

        arr.display();
        // 查找66
        System.out.println("查找66："+arr.find(66));

        // 删除55
        System.out.println("删除55："+arr.delete(55));

        arr.display();
    }
}
