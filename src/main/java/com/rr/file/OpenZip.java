package com.rr.file;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by Limaoran on 2016/8/10.
 */
public class OpenZip {
    public static void main(String[] args) throws Exception{
        ZipFile file = new ZipFile("Z:\\Cloudera Hadoop 5&Hadoop高阶管理及调优课程\\课件和代码.zip");
        ZipEntry entry = file.getEntry("课件和代码");
        ZipInputStream is =  new ZipInputStream(file.getInputStream(entry));
        is.close();
    }
}
