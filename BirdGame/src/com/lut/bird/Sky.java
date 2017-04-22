package com.lut.bird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sky extends Actor {
	// Ψһ��һ��ͼƬ����,���Զ���Ϊ��̬��
	static BufferedImage image;
	private double x1,x2;
	// ���þ�̬�����,��ʼ����̬��Դ
	static {
		// ����java�ṩ��API��ͼƬ��ȡ���ڴ������
		image = load("res/bg.png");
	}

	public BufferedImage getImage() {
		return image;
	}
	public void move(){
		x1-=1.4;
		x2-=1.4;
		if(x1<-width)
			x1=width;
		if(x2<-width)
			x2=width;
	}
	public Sky() {
		x = 0;
		y = 0;
		
		width = 432;
		height = 644;
		x1=0;
		x2=width;
	}
	public void paint(Graphics g){
		g.drawImage(getImage(), (int)x1, y, null);
		g.drawImage(getImage(), (int)x2, y, null);
	}
}
