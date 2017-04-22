package cn.lut.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private ServerSocket ss;
	
	public WebServer(){
		try {
			ss = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ö˿ڱ�ռ��");
			throw new RuntimeException(e);
		}
	}
	public void start(){
		try {
			//0000 1000 0000  0000  
			//1111 1111 1111  1111
			System.out.println("�ȴ�����");
			Socket socket = ss.accept();
			//�ɹ����ӵ��ͻ���
			System.out.println("���ӳɹ�:"+socket);
			InputStream in =socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			int STR=0;
			int INT=1;
			int LONG=2;
			int DOUBLE=3;
			
			//��ͻ��˷�������
			byte[]value="Hello World!,���".getBytes();
			int length=value.length;
			
			int b1=length & 0xff;
			int b2=length>>8&0xff;
			int b3=length >>16 &0xff;
			int b4=length >>24 &0xff;
			
			out.write(STR);//1byte
			out.write(b1);
			out.write(b2);
			out.write(b3);
			out.write(b4);
			
			out.write(value);
			out.flush();//ˢ������
			
			//����ʹ�ý���ձ���ر�socket
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�������!!");
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}

}
