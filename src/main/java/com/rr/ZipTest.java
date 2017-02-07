package com.rr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) throws FileNotFoundException ,Exception{
		
//		ZipFile
//		ZipEntry
//		ZipInputStream
//		ZipOutputStream
		String files [] = new String[]{"G:/txt/计算机/23招打造极速WINXP.txt",
		"G:/txt/计算机/Windowsxp自动登录问题.txt"};
		
		compZip(files,"z:/");
	}
	public static void compZip(String [] srcFiles ,String descDir ) throws Exception{
		
		File file = new File(descDir+"test_"+new Date().getTime()+".zip");
		OutputStream os = new FileOutputStream(file);
		ZipOutputStream zos = new ZipOutputStream(os);
		
		
		InputStream is = null;
		byte [] bs = new byte[1024];
		int temp = 0;
		
		for(int i=0;i<srcFiles.length;i++){
			File f = new File(srcFiles[i]);
			ZipEntry entry = new ZipEntry(f.getName());
			zos.putNextEntry(entry);
			is = new FileInputStream(f.getPath());
			while((temp=is.read(bs))>-1){
				zos.write(bs, 0, temp);
			}
			zos.closeEntry();
			is.close();
		}
		zos.close();
	}
}
