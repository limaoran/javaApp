package com.rr.algorithms.obj;

/**
 * 存储对象的数组
 * 插入排序
 * Created by Limaoran on 2016/9/16.
 */
public class ClassDataSortArray {
    private Person [] arr ;
    private int length;
    public ClassDataSortArray(int max){
        arr = new Person[max];
        length = 0;
    }
    public int size(){return length;}

    public Person find(String searchName){
        int j ;
        for(j=0;j<length;j++){
            if(arr[j].getLastName().equals(searchName)){
                break;
            }
        }
        if(j==length){  //没有找到
            return null;
        }else{
            return arr[j];
        }
    }
    public void insert(String lastName,String firstName,int age){
        arr[length] = new Person(lastName,firstName,age);
        length++;
    }

    /**
     * 根据姓删除 lastName
     * @param searchName
     * @return
     */
    public boolean delete(String searchName){
        int j;
        for(j=0;j<length;j++){
            if(arr[j].getLastName().equals(searchName)){
                break;
            }
        }
        if(j==length) return false;
        for(int k=j;k<length-1;k++){
            arr[k] = arr[k+1];
        }
        length--;
        return true;
    }

    public void display(){
        for(int i=0;i<length;i++){
            arr[i].display();
        }
    }

    /**
     * 插入排序，根据lastName排序
     */
    public void sortInsert(){
        int in,out;
        Person tempP ;
        for(out=1;out<length;out++){
            tempP = arr[out];
            for(in=out;in>0 && arr[in-1].getLastName().compareTo(tempP.getLastName()) > 0;in--){
                arr[in] = arr[in-1];
            }
            arr[in] = tempP;
        }
    }

    /**
     * 插入排序，根据age排序
     */
    public void sortInsert4Age(){
        Person tempP ;
        for(int out=1,in=0;out<length;out++){
            tempP = arr[out];
            for(in = out;in>0 && arr[in-1].getAge()>tempP.getAge();in--){
                arr[in] = arr[in-1];
            }
            arr[in] = tempP;
        }
    }

    public static void main(String[] args) {
        int size = 100;
        ClassDataSortArray arr = new ClassDataSortArray(size);
        arr.insert("Evans","Patty",24);
        arr.insert("Smith","Lorraine",22);
        arr.insert("Yee","Tom",33);
        arr.insert("Adams","Henry",42);
        arr.insert("Bot","Hali",41);
        arr.insert("Stimson","Henry",26);
        arr.insert("Sven","Tom",37);
        arr.insert("Potter","Hali",51);

        arr.display();

        Person p = arr.find("Sven");
        System.out.println("查找结果："+p);

//        arr.delete("Sven");
//        arr.delete("Yee");

        arr.sortInsert();

        arr.display();

        System.out.println("根据age排序：");
        arr.sortInsert4Age();
        arr.display();
    }
}
