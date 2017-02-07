package com.rr;

/**
 * 吸血鬼数字
 * @author Administrator
 *
 */
class XiXueGui_Test {
	public static void main(String[] args) {
		System.out.println("吸血鬼数字：");
		for(int a=10;a<100;a++)
			for(int b=10;b<100;b++){
		//	int a = 10;
		//	int b = 10;
			String result = Integer.toString((a*b));
		//	System.out.println(result);
			String stra = Integer.toString(a);
			String strb = Integer.toString(b);
			StringBuilder sb = new StringBuilder(result);
			
			char [] arraya = stra.toCharArray();
			char [] arrayb = strb.toCharArray();
			int temp = 0;
			for(int i=0;i<arraya.length;i++){
			//	System.out.println(sb.indexOf("22"));
				if(sb.indexOf(arraya[i]+"") >= 0){
					//删除结果中包含数值1的内容
					sb.deleteCharAt(sb.indexOf(arraya[i]+""));
					temp ++ ;
				}
				//	sb.deleteCharAt(sb.charAt(arraya[i]));
			}
			for(int i=0;i<arrayb.length;i++){
				if(sb.indexOf(arrayb[i]+"") >= 0){
					//删除结果中包含数值b的内容
					sb.deleteCharAt(sb.indexOf(arrayb[i]+""));
					temp ++ ;
				}
			}
			//System.out.println(sb.length());
			
			//如果sb的长度==0，并且删除了4次，则说明删除成功
			if(sb.length()==0 && temp==4){
				System.out.println("\t这一对数值是正确的："+a+"*"+b+"="+result);
			}
		}
	}
}
