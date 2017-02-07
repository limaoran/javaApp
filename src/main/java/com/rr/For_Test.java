package com.rr;

/**
 * continue、break的使用
 * 
 *  1.一般的continue会退回最内层循环的开头（顶部），并继续执行
 *  2.带标签的continue会到达标签的位置，并重新进入紧接在那个标签后面的循环。
 *  3.一般的break会中断并跳出当前循环
 *  4.带标签的break会中断并跳出标签所指的循环
 *  
 *  要记住的重点是：在Java里需要使用标签的唯一理由就是因为有循环嵌套存在，而且想从多层嵌套中break或continue。
 * @author Administrator
 *
 */
public class For_Test {
	public static void main(String[] args) {
		
		//在for语句中可以使用,分隔符声明多个变量
		for(int i = 1, j=0 ; i< 5 && j<5 ; i = j+i ,j++ ){
			System.out.println("i="+i+"\tj="+j);
		}
		
		loop:
			for(int i=0;i<30;i++){
				System.out.println("for\ti="+i);
				for(int j = 4; j<10 ; j++){
					System.out.println("for\t\tj="+j);
					if(j>6){
						System.out.println("跳出for循环");
						continue loop;
					}
				}
			}
		//continue loop;是中断当前迭代，从外部迭代继续开始
		//break loop;是直接跳出当前的所有循环以及外层循环
		
		
	//	print();
	}

	static void print(){
		int i = 0;
		loop:
			while(true){
				System.out.println("i="+i);
				if(i++ > 4){
					break loop;
				}
			};
			
		for(;;){
			//for语句的无穷循环 与while(true); 是等价的。
		}
	}
}
