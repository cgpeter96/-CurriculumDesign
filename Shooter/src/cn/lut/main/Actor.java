package cn.lut.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public abstract class Actor {

	protected double x, y, width, height, step;
	protected int life = 1;
	protected int state = LIFE;
	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;

	public Actor() {

	}

	/**
	 * �����ɻ��Ĺ�����
	 * 
	 * @param width
	 * @param height
	 */
	public Actor(int width, int height) {
		this.width = width;
		this.height = height;
		x = Math.random() * (480 - width);
		step = Math.random() * 4 + 1.8;
		// y = -height;
	}

	public void paint(Graphics g) {
		g.drawImage(getImage(), (int) x, (int) y, null);
	}

	public abstract BufferedImage getImage();

	public void move() {
		
		y += step;
	}

	public boolean duang(Actor otherOne) {
		double x1, x2, y1, y2;
		x1 = x - otherOne.width;
		x2 = x + width;
		y1 = y - otherOne.height;
		y2 = y + height;
		return x1 < otherOne.x && otherOne.x < x2 && y1 < otherOne.y && otherOne.y < y2;
	}

	public static BufferedImage load(String name) {
		try {
			BufferedImage img = ImageIO.read(Actor.class.getClassLoader().getResourceAsStream(name));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ǰ���尤����
	 */
	public void hit(){
		if(isLife()){
			life--;
			if(life==0){
				state=DEAD;
			}
		}
	}
	/**
	 *����Ƿ����,��������ֱ��ɾ����
	 */
	public void checkOutOfBounds(){
		if(isLife()){
			if(outOfBounds()){
				state=REMOVE;
			}
		}
	}
	/**
	 * ÿ�����඼����ʵ�ֵķ���,���ÿ�������Ƿ����
	 */
	public boolean outOfBounds(){
			return y>700;
	}

	public boolean isLife() {
		return state == LIFE;
	}
	public boolean isDead(){
		return state == DEAD;
	}
	public boolean isRemove() {
		return state == REMOVE;
	}
	public void goDead(){
		if(isLife()){
			state=DEAD;
			life=0;
		}
	}
}
