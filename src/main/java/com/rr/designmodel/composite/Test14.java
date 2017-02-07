package com.rr.designmodel.composite;

import java.util.List;

/**
 * 组合模式，最典型的例子：Java实现的菜单栏
 * Created by Limaoran on 2016/11/17.
 */
public class Test14 {
    public static void main(String[] args) {
        // C盘
        Folder rootFolder = new Folder("C:");
        // test目录
        Folder testFolder = new Folder("test");
        // test.txt文件
        File testFile = new File("test.txt");

        rootFolder.add(testFolder);
        rootFolder.add(testFile);

        Folder test2Folder = new Folder("test2");
        File test2File = new File("test2.txt");
        testFolder.add(test2Folder);
        testFolder.add(test2File);

        Folder test3Folder = new Folder("test3");
        File test3File = new File("test3.txt");
        test2Folder.add(test3Folder);
        test2Folder.add(test3File);

        displayTree(rootFolder,0);
    }
    public static void displayTree(IFile folder,int deep){
        for(int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        // 显示自身的名称
        folder.display();
        // 获得子树
        List<IFile> list = folder.getChild();
        // 遍历子树
        for(IFile file : list){
            if( file instanceof File){
                for(int i = 0; i <= deep; i++) {
                    System.out.print("--");
                }
                file.display();
            }else{
                displayTree(file,deep + 1);
            }
        }
    }
}
