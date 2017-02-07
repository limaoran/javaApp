package com.rr.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多次排序 案例
 * Created by Limaoran on 2016/6/20.
 */
public class CompareTest {
    public static void main(String[] args) {
        Person p1 = new Person("b",2,2,3);
        Person p2 = new Person("b",2,2,2);
        print(p1.compareTo(p2));
//        System.out.println("a".compareTo("a"));
        List<Person> list = new ArrayList<>(20);
        Random random = new Random();
        int max= 10;
        for(int i=0;i<20;i++){
            list.add(new Person("LiSi",random.nextInt(max),random.nextInt(max),random.nextInt(max)));
        }
        System.out.println("源数据：");
        for(Person p : list){
            System.out.println(p);
        }
        Person temp = null;
        //start
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))<0){   //<返回负数 交换后大数在前； >返回1，交换后小数在前
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("结果数据：");
        for(Person p : list){
            System.out.println(p);
        }
    }
    static void print(int v){
        switch (v){
            case 0:
                System.out.println("相等");
                break;
            case 1:
                System.out.println("大于");
                break;
            case -1:
                System.out.println("小于");
                break;
        }
    }
    static class Person  implements Comparable {
        String name="";
        int i1=0;
        int i2=0;
        int i3=0;

        public Person(String name, int i1, int i2, int i3) {
            this.name = name;
            this.i1 = i1;
            this.i2 = i2;
            this.i3 = i3;
        }

        /**
         * 大的返回1，小的返回-1，相等的返回0
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            if(o instanceof Person){
                Person p2 = (Person) o;
                if(name.equals(p2.name)){
                    if(i1==p2.i1){
                        if(i2==p2.i2){
                            if(i3==p2.i3){
                                return 0;
                            }
                            return i3>p2.i3?1:-1;
                        }
                        return i2>p2.i2?1:-1;
                    }
                    return i1>p2.i1?1:-1;
                }
                return name.compareTo(p2.name);
            }
            throw new ClassCastException("The Object is not a Person!");
        }

        @Override
        public String toString() {
            return "Person[  " +
                    "name='" + name + '\'' +
                    ", i1=" + i1 +
                    ", i2=" + i2 +
                    ", i3=" + i3 +
                    ']';
        }
    }

    /**
     * 冒泡排序
     * @param a
     */
    public void sort(int[] a)  {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i)    {
            for (int j = 0; j < i; ++j)  {
                if (a[j + 1] < a[j])   {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
