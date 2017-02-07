package com.rr.download.net;

public class TestMethod {
	public TestMethod() 
	 { ///xx/weblogic60b2_win.exe 
	 try{ 
	 SiteInfoBean bean = new SiteInfoBean("http://www.win2.cn/driver/R3_4-in-Right_V1.201.zip",
	     "Z:/","R3_4-in-Right_V1.201.zip",5); 
	 //SiteInfoBean bean = new SiteInfoBean("http://localhost:8080/down.zip","L:\\temp", "weblogic60b2_win.exe",5); 
	 SiteFileFetch fileFetch = new SiteFileFetch(bean); 
	 fileFetch.start(); 
	 } 
	 catch(Exception e){e.printStackTrace ();} 
	 }

	public static void main(String[] args) {
		new TestMethod();
	}
}
