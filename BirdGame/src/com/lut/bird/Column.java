package com.lut.bird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Column extends Actor {
	private int gap = 144;
	private int distance=280;
	
	public int getGap(){
		return gap;
	}
	static BufferedImage image;
	// ���þ�̬�����,��ʼ����̬��Դ
	static {
		// ����java�ṩ��API��ͼƬ��ȡ���ڴ������
		image = load("res/column.png");
	}

	public Column(int index) {
		x = 432+index*distance;
		y = -(int) (Math.random() * (430 - 130) + 130);
		width = 78;
		height = 1200;
	}
	

	public BufferedImage getImage() {
		return image;
	}
	public void move(){
		x--;
		if(x==-width){
			x=2*distance-width;
			y = -(int) (Math.random() * (511 - 130) + 130);
		}
	}
}
