package com.rr.algorithms.graph;

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
