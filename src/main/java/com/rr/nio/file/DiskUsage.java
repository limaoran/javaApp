package com.rr.nio.file;

import java.io.IOException;
import java.nio.file.*;

/**
 * Example utility that works like the df(1M) program to print out disk space information
 * 示例实用程序，它像 df(1M) 程序将打印出来的磁盘空间信息
 * Created by Limaoran on 2017/1/3.
 */
public class DiskUsage {

    static final long K = 1024;

    public static void printFileStore(FileStore store) throws IOException {
        long total = store.getTotalSpace() / K;
        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / K;
        long avail = store.getUsableSpace() / K;

        String s = store.toString();
        if (s.length() > 20) {
            System.out.println(s);
            s = "";
        }
        System.out.format("%-20s %12d %12d %12d\n",s,total,used,avail);
    }

    public static void main(String[] args) throws IOException {
        System.out.format("%-20s %12s %12s %12s\n", "Filesystem", "kbytes", "used", "avail");
        if(args.length==0){
            FileSystem fs = FileSystems.getDefault();
            for(FileStore store : fs.getFileStores()){
                printFileStore(store);
            }
        }else{
            for(String file : args){
                FileStore store = Files.getFileStore(Paths.get(file));
                printFileStore(store);
            }
        }
    }
}
