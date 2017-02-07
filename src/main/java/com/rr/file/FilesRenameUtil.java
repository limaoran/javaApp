package com.rr.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 对文件进行重命名，支持多文件、文件夹
 * Created by Limaoran on 2016/6/7.
 */
public class FilesRenameUtil {

    /**file or dir*/
    private String path;
    /**确定是否为文件夹*/
    private boolean isDir = false;
    /**是否为多文件处理，支持多文件，目录下多文件*/
    private boolean multi = false;
    /**如果处理文件夹，是否处理子文件夹，默认true*/
    private boolean parseChilds = true;
    private FileFilter fileFilter = null;
    private DoRenameI func = null;

    public FilesRenameUtil(String path,boolean isDir,boolean multi){
        this.path = path;
        this.isDir = isDir;
        this.multi = multi;
    }
    public FilesRenameUtil(String path,boolean isDir,boolean multi,boolean parseChilds,FileFilter fileFilter){
        this(path,isDir,multi);
        this.parseChilds = parseChilds;
        this.fileFilter = fileFilter;
    }
    static interface DoRenameI{
        void doAction(File file);
    }
    /**
     * 返回处理成功的文件个数
     * @param func 用户指定的重命名方法
     * @return
     */
    public int runTask(DoRenameI func){
        this.func = func;
        File file = new File(path);
        return doRename(file,0);
    }

    /**
     * 重命名文件
     * @param file 子文件
     * @param level 第一层目录为0，子目录为1
     * @return
     */
    private int doRename(File file,int level){
        if(file==null ) return 0;
        int result = 0;
        if(isDir && file.isDirectory() ){
            //处理目录
            if(multi ) {
                File [] fs = null;
                if(fileFilter!=null){
                    fs = file.listFiles();
                }else{
                    fs = file.listFiles(fileFilter);
                }
                if(parseChilds){ //递归子文件夹
                    for(File f : fs) {
                        result += doRename(f,level+1);
                    }
                }else{
                    if(level>1){
                        return 0;
                    }
                }
            }
        }else{
            //只处理文件
            func.doAction(file);
        }
        return result;
    }

    public static void main(String[] args) {
//        String path = "F:\\movie\\新概念英语\\";
//        String path = "F:\\movie\\新概念英语\\Book1";
//        String path = "F:\\Robocode课程";
        String path = "C:\\Temp\\跟着老男孩一步步学习Shell高级编程实战视频教程";
//        String name = "[西安领航-何其锟]_";
//        String name = "[西安领航-何足道]_";
        String name = "【shell高级编程第四部分】";
        FilesRenameUtil util = new FilesRenameUtil(path, true, true, true, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
//                return pathname.getName().contains("(ED2000.COM)") || pathname.getName().contains("[新版新概念英语1-4册全部视频和课本].");
//                return pathname.getName().contains("Book-") && pathname.getName().endsWith(".rm");
//                return pathname.getName().contains(name ) && pathname.getName().endsWith(".avi");
                return pathname.getName().contains(name ) && pathname.getName().endsWith(".avi");
            }
        });
        util.runTask(new DoRenameI() {
            @Override
            public void doAction(File file) {
//                File destFile = new File(file.getParent()+File.pathSeparator+file.getName().replace("[新版新概念英语1-4册全部视频和课本].","").replace("(ED2000.COM)",""));
//                File destFile = new File(file.getParent()+File.separator+file.getName().replace("Book-","Book1-"));
                File destFile = new File(file.getParent()+File.separator+file.getName().replace(name,""));
                file.renameTo(destFile);
            }
        });
        System.out.println("task over!");
    }
}
