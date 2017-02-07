# 数组

大纲：

* 数组封装
* 有序数组和二分查找
* 存储对象和大O表示法
* 冒泡排序
* 选择排序
* 插入排序
* 对象的插入排序


## 数组封装
```java
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
```

结果：
```text
77,44,55,66,99,88,33,22,0,11
查找66：true
删除55：true
77,44,66,99,88,33,22,0,11
```

##

## 有序数组和二分查找

有序数组二分查找的比较次数：

| 数据量 | 所需比较次数 |
| --- | --- |
| 10 | 4 |
| 100 | 7 |
| 1,000 | 10 |
| 10,000 | 14 |
| 100,000 | 17 |
| 1,000,000 | 20 |
| 10,000,000 | 24 |
| 100,000,000 | 27 |
| 1,000,000,000 | 30 |

有序数组
* 优点：查找速度比无序数组快多了。
* 缺点：插入时要按排序方式把后面的数据进行移动。

有序数组和无序数组共同的缺点：删除数据项时，必须把后面的数据向前移动来填补删除项的空洞。

### 算法实现：
```java
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
```

二分查找和线性查找对比的测试结果：

| 次数 | 二分查找插入时间消耗 | 线性查找插入时间消耗 |
| --- | --- | --- |
| 1千 | 4毫秒 | 6毫秒 |
| 1万 | 38毫秒 | 61毫秒 |
| 2万 | 335毫秒 | 425毫秒 |
| 20万 | 8545毫秒 | 13749毫秒 |
| 50万 | 47368毫秒 | 89501毫秒 |


## 存储对象的数组和大O表示法

|查找方式|大O表示法|执行效率|
|---|---|---|
|线性查找|O(N)|还可以|
|二分查找|O(log N)|良好|
|无序数组的插入|O(1)|优秀|
|有序数组的插入|O(N)|还可以|
|无序数组的删除|O(N)|还可以|
|有序数组的删除|O(N)|还可以|

O(1) > O(log N) > O(N) > O(N的2次方)

## 简单排序_冒泡排序

冒泡排序规则：
1. 比较两个相邻的对象
2. 如果左边的大于右边的，则调换位置
3. 向右移动一个位置，比较接下来的两个对象

算法实现：
```java
public void sortBubble(){
    int out,in ;
    long tempValue;
    for(out=length-1;out>1;out--){
        for(in=0;in<out;in++){
            if(arr[in]>arr[in+1]){
                tempValue = arr[in];
                arr[in] = arr[in+1];
                arr[in+1] = tempValue;
            }
        }
    }
}
```
如果用大O表示法，来表示它的效率的话，是O(N的2次方)，属于最差的了。
算法简单，但是效率很低！

## 选择排序

算法实现：
```java
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
```

效率比冒泡排序稍微好一点！
如果用大O表示法，来表示它的效率的话，是O(N)。

## 插入排序（快速排序）

算法实现：
```java
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
```

插入排序比冒泡排序快1倍，比选择排序要快一些！
如果排序的数据是逆序的话，这种情况下插入排序的效率就不比冒泡排序快了！

## 简单排序算法的完整代码实现和效率对比

代码实现：
```java
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
```

效率对比：

| 排序类型 | 1万数据条耗时 | 5万数据条耗时 |10万数据条耗时|
| --- |--- | --- | --- |
| 冒泡排序 | 426毫秒   | 8630毫秒 | 27868毫秒 |
| 选择排序 | 237毫秒  | 4025毫秒 | 15530毫秒 |
| 插入排序 | 37毫秒 | 497毫秒 | 1852毫秒 |

