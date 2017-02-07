package com.rr.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Limaoran on 2017/1/3.
 */
public class FileType {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("usage: java FileType file...");
            System.exit(-1);
        }
        for (String arg: args) {
            Path file = Paths.get(arg);
            String type;
            if (Files.isDirectory(file)) {
                type = "directory";
            } else {
                type = Files.probeContentType(file);
                if (type == null)
                    type = "<not recognized>";
            }
            System.out.format("%s\t%s%n", file, type);
        }
    }
}
