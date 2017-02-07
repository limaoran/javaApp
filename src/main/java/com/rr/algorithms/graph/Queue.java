package com.rr.algorithms.graph;

/**
 * 广度优先搜索使用的队列
 * Created by Limaoran on 2016/9/19.
 */
public class Queue {
    private int size = 20;
    private int [] queArray;
    private int front;
    private int rear;

    public Queue(){
        queArray = new int[size];
        front = 0;
        rear = -1;
    }
    public void insert(int v){
        if(rear==size-1){
            rear = -1;
        }
        queArray [++rear] = v;
    }
    public int remove(){
        int temp = queArray[front ++]; //从最头拿
        if(front == size){
            front = 0;
        }
        return temp;
    }
    public boolean isEmpty(){
        return rear+1 == front || front+size-1 == rear;
    }
}
