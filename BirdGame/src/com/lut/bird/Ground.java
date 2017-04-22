package com.lut.bird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground extends Actor {
	static BufferedImage image;
	// ���þ�̬�����,��ʼ����̬��Դ
	static {
		// ����java�ṩ��API��ͼƬ��ȡ���ڴ������
		image = load("res/ground.png");
	}

	public Ground() {
		x = 0;
		y = 500;
		width = 800;
		height = 146;
	}

	public BufferedImage getImage() {
		return image;
	}
	public void move(){
		x--;
		if(x==-36){
			x=0;
		}
	}
}
