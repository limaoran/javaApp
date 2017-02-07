package com.rr.algorithms.graph;

import java.util.Arrays;

/**
 * 有向图的拓扑排序
 * Created by Limaoran on 2016/9/19.
 */
public class TopoApp {
    static class Vertex{
        public char label;
        public Vertex(char label){
            this.label = label;
        }
    }
    static class Graph{
        private int maxVerts = 20;
        private Vertex[] vertices;
        private int [] [] adjMat;
        private int nVerts;
        // 存储拓扑排序的结果
        private char[]sortedArray;

        public Graph(){
            vertices = new Vertex[maxVerts];
            adjMat = new int[maxVerts][maxVerts];
            nVerts = 0;
            for(int i=0;i<maxVerts;i++){
                for(int j=0;j<maxVerts;j++){
                    adjMat[i][j] = 0;
                }
            }
            sortedArray = new char[maxVerts];
        }
        public void addVertex(char label){
            vertices[nVerts++] = new Vertex(label);
        }

        /**
         * 添加有向图的边
         * @param start
         * @param end
         */
        public void addEdge(int start,int end){
            adjMat[start][end] = 1;
        }
        public void displayVertex(int v){
            System.out.print(vertices[v].label+",");
        }

        /**
         * 拓扑排序
         */
        public void topo(){
            int orig_nVerts = nVerts ;
            while(nVerts>0){
                int currentVertex = noSuccessors();
                System.out.println("currentVertex:"+currentVertex+",value:"+vertices[currentVertex].label);
                if(currentVertex ==-1){
                    System.out.println("Error:Graph has cycles");
                    break ;
                }
                // 数量递减
                nVerts --;
                sortedArray[nVerts] = vertices[currentVertex].label;
                // 从图中删除当前顶点
                deleteVertex(currentVertex);
                // 清空后面的数据
                clear(nVerts);
            }
            System.out.println("Topologically sorted order:");
            for(int i=0;i<orig_nVerts;i++){
                System.out.print(sortedArray[i]+" ");
            }
            System.out.println();
        }

        /**
         * 查找图中没有后继顶点的顶点
         * @return -1表示没有找到
         */
        public int noSuccessors(){
            boolean isEdge;
            for(int row=0;row<nVerts;row++){
                isEdge = false;
                for(int col =0 ;col<nVerts;col++){
                    if(adjMat[row][col] > 0){
                        isEdge = true;
                        break;
                    }
                }
                if(!isEdge){
                    return row;
                }
            }
            return -1;
        }
        public void deleteVertex(int delVert){
            if(delVert != nVerts){
                // 要删除的顶点不是最后一个就要处理邻接矩阵
                for(int i=delVert;i<nVerts;i++){
                    // 删除顶点，后面的元素向前移动
                    vertices[i] = vertices[i+1];
                }
                for(int row = delVert;row<nVerts;row++){
                    // 把邻接矩阵中删除行，后面的行向上移动。
                    for(int col=0;col<nVerts;col++){
                        adjMat [row][col] = adjMat[row+1][col];
                    }
                }
                for(int col=delVert;col<nVerts;col++){
                    for(int row=0;row<nVerts;row++){
                        adjMat [row][col] = adjMat[row][col+1];
                    }
                }
            }else{
                // 删除最后一行和列

            }

        }
        public void moveRowUp(int row,int length){

        }
        public void moveColLeft(int col,int length){

        }
        public void clear(int ver){
            for(int row=ver;row<adjMat.length;row++){
                for(int col=0;col<adjMat[row].length;col++){
                    adjMat[row][col] = 0;
                }
            }
            for(int col=ver;col<adjMat.length;col++){
                for(int row=0;row<adjMat[col].length;row++){
                    adjMat[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        // 添加顶点
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        // 添加边
        graph.addEdge(0,3); // AD
        graph.addEdge(0,4); // AE
        graph.addEdge(1,4); // BE
        graph.addEdge(3,6); // DG
        graph.addEdge(4,6); // EG
        graph.addEdge(6,7); // GH
        graph.addEdge(5,7); // FH
        graph.addEdge(2,5); // CF

        // 正确结果：BAEDGCFH 或者 CFBAEDGH
        graph.topo();
        // TODO 此处算法有问题，后续调整！
    }
}
