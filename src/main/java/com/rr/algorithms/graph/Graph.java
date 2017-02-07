package com.rr.algorithms.graph;

/**
 * Created by Limaoran on 2016/9/19.
 */
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
        System.out.print(vertex.label+",");
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
        System.out.println();
        // 把所有的顶点访问标志改回去
        resetState();
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
        System.out.println();
        resetState();
    }

    /**
     * 最小生成树
     */
    public void mst(){
        vertices[0].wasVisited = true;
        theStack.push(0);
        while(!theStack.isEmpty()){
            int currentVertex = theStack.peek();
            int v = getAdjUnVisitedVertex(currentVertex);
            if(v==-1){
                theStack.pop();
            }else{
                theStack.push(v);
                vertices[v].wasVisited = true;
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print("\t");
            }
        }
        System.out.println();
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
    public void printAdj(){
        for(int i=0;i<length;i++){
            if(i==0)System.out.print("-\t");
            System.out.print(vertices[i].label + "\t");
            if(i==length-1) System.out.println();
        }
        System.out.println("-----------------------------");
        for(int i=0;i<length;i++){
            System.out.print(vertices[i].label+"\t");
            for(int j=0;j<length;j++){
                System.out.print(adjMat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
