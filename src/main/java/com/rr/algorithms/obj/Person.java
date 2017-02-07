package com.rr.algorithms.obj;

/**
 * Created by Limaoran on 2016/9/16.
 */
public class Person {
    private String lastName;
    private String firstName;
    private int age;
    public Person(String last,String first,int age){
        this.lastName = last;
        this.firstName = first;
        this.age = age;
    }
    public void display(){
        System.out.print("Last Name:"+lastName);
        System.out.print(", First Name:"+firstName);
        System.out.print(", Age:"+age);
        System.out.println();
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
