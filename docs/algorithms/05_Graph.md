# 图


## 图简介和图搜索

图是用于对数据间关系进行编码的一种机制。
图是一种与树有些相像的数据结构。

图的类型：

* 有向图
* 无向图

图的类型划分还有：

* 连通图：一个顶点能够把所有的点都连接起来
* 非连通图：没有办法吧所有的点都连起来


* 带权图
* 无权图

图的搜索：
* 深度优先搜索（DFS）：在搜索到尽头的时候，深度优先搜索用一个栈可以记下来下一步的走向。
* 广度优先搜索（BFS）

## 连通图示例

![test](file:/E:/OneDrive/image/liantongtu.png)

图之间的连线用二维数组表示

|   | A | B | C | D |
|---|---|---|---|---|
| A | 0 | 1 | 1 | 1 |
| B | 1 | 0 | 0 | 1 |
| C | 1 | 0 | 0 | 0 |
| D | 0 | 1 | 0 | 0 |

## 一：深度优先搜索（DFS）

简单说:这种算法就是要得到距离起始点最远的顶点，然后在不能继续前进的时候返回，这就叫做深度优先搜索。
用栈实现。


## 二：广度优先搜索（BFS）

简单说：先计算距离起始点最近的顶点，然后再计算距离远的。
用队列实现。

## 三：最小生成树（MST）

如果有一种算法可以去掉多于的连线，那么这就是最小生成树。
也就是说要有一种算法把所有的点连接起来，而且**以最少的边保证它们彼此之间是连通的**。

## 四：有向图的拓扑排序

拓扑排序是可以用图模拟的另一种操作，主要用来表示一种情况：
某些项目或事件必须按照一个特定的顺序排列或发生的，这种情况就是有向图的拓扑排序。



## 完整代码实现

顶点：Vertex.java

```java
/**
 * 顶点
 * Created by Limaoran on 2016/9/19.
 */
public class Vertex {
    public char label ;
    /** 记录是否被访问过 */
    public boolean wasVisited;
    public Vertex(char label){
        this.label = label;
        wasVisited = false;
    }
}
```
实现深度优先搜索使用的栈：StackX.java
```java
/**
 * 实现深度优先搜索使用的栈
 * Created by Limaoran on 2016/9/19.
 */
public class StackX {
    private final int SIZE = 20;
    private int [] st;
    private int top;
    public StackX(){
        st = new int[SIZE];
        top = -1;
    }
    public void push(int value){
        top ++;
        st[top] = value;
    }
    public int pop(){
        return st[top -- ]; //先返回，后--
    }

    /**
     * 只返回，不删除
     * @return
     */
    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return top < 0 ;
    }
}
```
广度优先搜索使用的队列：Queue.java
```java
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
```
图：Graph.java
```java
public class Graph {
    /** 最大顶点 */
    private int maxVerts = 20;
    /** 存放顶点的数组 */
    private Vertex [] vertices ;

    /** 邻接矩阵，用来存顶点之间的连通关系。 */
    private int adjMat [][] ;

    /** 当前的顶点数量 */
    private int length ;

    /** 进行深度优先搜索的时候用的栈 */
    private StackX theStack;

    /** 进行广度优先搜索的时候用的队列 */
    private Queue theQueue;

    public Graph(){
        vertices = new Vertex[maxVerts] ;
        adjMat = new int[maxVerts][maxVerts];
        length = 0;
        // 初始化矩阵，无连接线
        for(int i=0;i<maxVerts;i++){
            for(int j=0;j<maxVerts;j++){
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        theQueue = new Queue();
    }

    /**
     * 添加顶点
     */
    public void addVertex(char label){
        vertices[length] = new Vertex(label);
        length ++ ;
    }

    /**
     * 添加边
     */
    public void addEdge(int start,int end){
        adjMat [start][end] = 1;
        adjMat [end][start] = 1;
    }

    /**
     * 显示一个顶点
     * @param v
     */
    public void displayVertex(int v){
        Vertex vertex = vertices[v];
        System.out.println(vertex.label+","+vertex.wasVisited);
    }

    /**
     * 深度优先搜索
     */
    public void dfs(){
        // 模拟，从第一个顶点开始

        // 第一个顶点标志为被访问过的
        vertices[0].wasVisited = true;
        displayVertex(0); //显示访问的顶点
        theStack.push(0);

        while(!theStack.isEmpty()){
            int v = getAdjUnVisitedVertex(theStack.peek());
            if(v==-1){
                theStack.pop(); // 弹出顶点
            }else{
                vertices[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        // 把所有的顶点访问标志改回去
        resetState();
    }

    /**
     * 还原顶点的原始状态
     */
    public void resetState(){
        for(int i=0;i<length;i++){
            vertices[i] .wasVisited = false;
        }
    }

    /**
     * 广度优先搜索
     */
    public void bfs(){
        vertices[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);

        int v2 ;
        while(!theQueue.isEmpty()){
            int v1 = theQueue.remove(); //从队头取出第一个顶点
            while((v2 = getAdjUnVisitedVertex(v1))!=-1){
                vertices[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        resetState();
    }

    /**
     * 获取指定顶点相邻接的一个未被访问过的顶点
     */
    public int getAdjUnVisitedVertex(int v){
        for(int i=0;i<maxVerts;i++){
            if(adjMat[v][i] == 1 && vertices[i].wasVisited==false){ //查找连通的，而且未访问过的
                return i;   //找到了一个与v顶点相邻接的未访问过的顶点
            }
        }
        return -1;
    }
}
```
测试程序
```java
public class MainApp {

    public static void main(String[] args) {
        Graph graph = new Graph();
        // 添加顶点
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        // 添加边
        graph.addEdge(0,1); // AB
        graph.addEdge(0,2); // AC
        graph.addEdge(0,3); // AD
        graph.addEdge(1,3); // BD
        graph.addEdge(3,4); // DE

        // 添加所有的连接线
//        for(int i=0;i<5-1;i++){
//            for(int j=i+1;j<5;j++){
//                graph.addEdge(i,j);
//            }
//        }

        System.out.println("深度优先搜索：start！");
        graph.dfs();
        System.out.println("广度优先搜索：start！");
        graph.bfs();
        System.out.println("最小生成树：start！");
        graph.mst();
        graph.printAdj();
    }
}
```
测试结果：
```text
深度优先搜索：start！
A,B,D,E,C,
广度优先搜索：start！
A,B,C,D,E,
最小生成树：start！
A,B,	B,D,	D,E,	A,C,
```


