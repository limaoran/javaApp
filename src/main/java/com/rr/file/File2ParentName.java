package com.rr.file;

import java.io.File;

/**
 * Created by Limaoran on 2017/2/15.
 */
public class File2ParentName {
    public static void main(String[] args) {
        File file = new File("D:\\work\\直播APK");
        File [] files = file.listFiles((dir, name) -> dir.isDirectory());
        for(File f : files){
//            System.out.println(f.getParentFile().getPath());
            File[] child = f.listFiles();
            if(child!=null && child.length>0) {
                File childFile = child[0];
                childFile.renameTo(new File(childFile.getParentFile().getPath(),f.getName()+".apk"));
            }
        }
    }
}
