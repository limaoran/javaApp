package com.rr.frame;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDemo01 {
	public static void main(String[] args) throws IOException {
		Frame frame = new Frame();
		frame.setBounds(200, 60, 400, 320);
		frame.setTitle("图像浏览");
		
		//载入图片
		final Image image = ImageIO.read(new File("G:/图片/a (8).jpg"));
		
		Canvas canvas = new Canvas(){
			@Override
			public void print(Graphics g) {
				super.print(g);
				System.out.println("画");
				g.drawImage(image, 11, 11, null);
			}
		};
		canvas.print(image.getGraphics());
		
		//Panel panel = new Panel();
	//	ImageObserver 
		//panel.add(image);
		
		frame.setVisible(true);
		frame.add(canvas);
		
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}
