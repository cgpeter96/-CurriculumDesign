package cn.lut.server;

public class BinDemo {
	public static void main(String[] args) throws Exception{
		int length = 0x27652641;
		System.out.println(Integer.toBinaryString(length));
		int b1 = length & 0xff;//��8λ
		int b2 = (length >>> 8) & 0xff;
		int b3 = (length >>> 16) & 0xff;
		int b4 = (length >>> 24) & 0xff;
		/**
		 * >>>ȫ����0
		 * >>����λ�����1��0
		 */
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(b3));
		System.out.println(Integer.toBinaryString(b4));
		int l=b1|(b2<<8)|(b3<<16)|(b4<<24);
		System.out.println(Integer.toBinaryString(l));
		
		System.out.println("-----------------------");
		
		int n = '��';//24744   2^16=65535
		System.out.println(Integer.toBinaryString(n));
		byte[]bytes="��".getBytes("UTF-16BE");//B�Ǹ�λ��ǰ �ַ����ı���
		b1=bytes[0];
		b2=bytes[1];
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2&0xff));
		//�ַ������ݵĽ���
		String str = new String(bytes,"utf-16be");
		System.out.println(str);
		/**
		 * UTF-8 1�ֽ� 0XXXXXXX
		 *       2�ֽ� 110XXXXX 10XXXXXX
		 *       3�ֽ� 1110XXXX 10XXXXXX 10XXXXXX
		 *       4�ֽ� 11110XXX 10XXXXXX 10XXXXXX 10XXXXXX
		 *       
		 *         ��  01100000 10101000
		 * utf8--3�ֽ� 1110XXXX 10XXXXXX 10XXXXXX
		 * utf8            �� 11100110 10000010 10101000
		 */
		System.out.println("------------------------");
		byte []utf8="���".getBytes("utf-8");
		System.out.println(Integer.toBinaryString(utf8[0]&0xff));
		System.out.println(Integer.toBinaryString(utf8[1]&0xff));
		System.out.println(Integer.toBinaryString(utf8[2]&0xff));
		String s1="A".toLowerCase();
		String s =new String(utf8,"Utf-8");
		System.out.println(s);
	}

}
