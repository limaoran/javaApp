package com.rr.frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 计算器的例子
 * @author Administrator
 *
 */
public class OperatorDemo extends Frame{

	private TextField value1 = new TextField() ;
	private TextField value2 = new TextField();
	private Label result = new Label();
	
	public OperatorDemo(){
		//设置大小
		this.setSize(400,320);
		//设置位置
		this.setLocation(100,50);
		//设置标题
		this.setTitle("计算器");
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
	//	panel.setLayout(new GridLayout());
		panel.setLayout(new GridLayout(0,1) );
		
		this.add(panel);
		
		result.setFont(new Font("宋体",Font.LAYOUT_LEFT_TO_RIGHT, 16));
		
		Button btn1 = new Button("加");
		btn1.addMouseListener(new MouseAdapeterExtends(OperatorEnum.JIA));
		Button btn2 = new Button("减");
		btn2.addMouseListener(new MouseAdapeterExtends(OperatorEnum.JIAN));
		Button btn3 = new Button("乘");
		btn3.addMouseListener(new MouseAdapeterExtends(OperatorEnum.CHENG));
		Button btn4 = new Button("除");
		btn4.addMouseListener(new MouseAdapeterExtends(OperatorEnum.CHU));
		
		this.value1.setSize(100,40);
		this.value2.setSize(100,40);
		value1.setFont(new Font("楷体",Font.LAYOUT_LEFT_TO_RIGHT,40));
		value2.setFont(new Font("楷体",Font.LAYOUT_LEFT_TO_RIGHT,40));
		panel.add(this.value1);
		panel.add(this.value2);
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		this.result.setSize(100,40);
		panel.add(result);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("鼠标单击了！");
			}
		});
		
		//绑定事件
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
	
	public static void main(String[] args) {
		Frame f = new OperatorDemo();
		f.setVisible(true);
	}

	/**
	 * 添加事件
	 */
	public void addListener(OperatorEnum e){
		switch(e){
		case JIA:
			this.setResult(""+ (this.convertValue1() + this.convertValue2()));
			break;
		case JIAN:
			this.setResult(""+ (this.convertValue1() - this.convertValue2()));
			break;
		case CHENG:
			this.setResult(""+ (this.convertValue1() * this.convertValue2()));
			break;
		case CHU:
			this.setResult(""+ (this.convertValue1() / this.convertValue2()));
			break;
		}
	}
	
	public double convertValue1(){
		return Integer.parseInt(value1.getText());
	}
	public double convertValue2(){
		return Integer.parseInt(value2.getText());
	}
	/**
	 * 设置计算结果
	 * @param str
	 */
	public void setResult(String result){
		System.out.println("result="+result);
		this.result.setText("结果是："+result);
	}
	
	class MouseAdapeterExtends extends MouseAdapter{
		private OperatorEnum e;
		public MouseAdapeterExtends(OperatorEnum e){
			this.e = e;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			addListener(this.e);
		}
	}
}
enum OperatorEnum{
	/**
	 * 加
	 */
	JIA,
	/**
	 * 减
	 */
	JIAN,
	/**
	 * 乘
	 */
	CHENG,
	/**
	 * 除
	 */
	CHU
}
