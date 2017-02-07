package com.rr.effective;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Demo04 {
	public static void main(String[] args) {
		Person p =new Person(new Date());
		System.out.println(p.isBabyBoomer());
	}
}

/**
 * 除了重用非可变的对象之外，对于那些已知不会被修改的可变对象，你也可以重用它们。
 * 
 * 下面是一个比较微妙、也比较常见的反例，
 * 其中涉及到可变对象，它们的值一旦被计算出来之后就不会再有变化。
 * @author Administrator
 *
 */
class Person{
	private final Date birthday;
	
	public Person(Date birthday){
		this.birthday = birthday;
	}
	//Don't do this!
	public boolean isBabyBoomer(){
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1990, Calendar.JANUARY,1,0,0,0);
		Date boomStart = cal.getTime();
		cal.set(1999, Calendar.JANUARY,1,0,0,0);
		Date boomEnd = cal.getTime();
		return birthday.compareTo(boomStart) >= 0 && birthday.compareTo(boomEnd) < 0;
	}
}

/**
 * isBabyBoomei每次被调用的时候，
 * 都会创建一个新的Calendar、一个新的timeZone和两个新的Date实例，这是不必要的。
 * 
 * 下面的版本用一个静态的初始化器（initializer），
 * 避免了上面例子的低效率
 * @author Administrator
 *
 */
class Person2{
	private final Date birthday;
	public Person2(Date birthday){
		this.birthday = birthday;
	}
	/**
	 * The starting and ending dates of the baby boom
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.set(1990, Calendar.JANUARY,1,0,0,0);
		BOOM_START = cal.getTime();
		cal.set(1999, Calendar.JANUARY,1,0,0,0);
		BOOM_END = cal.getTime();
	}
	
	public boolean isBabyBoomer(){
		return birthday.compareTo(BOOM_START) >= 0 && birthday.compareTo(BOOM_END) < 0;
	}
}