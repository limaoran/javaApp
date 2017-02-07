package com.rr.algorithms.graph;

/**
 * 图搜索：
 *  深度优先搜索（DFS）
 *  广度优先搜索（BFS）
 *
 * 最小生成树（MST）
 * Created by Limaoran on 2016/9/19.
 */
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
