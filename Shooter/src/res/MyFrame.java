package res;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;  
  
  
/** 
 *  
 */  
  
/** 
 * @author Administrator 
 * 
 */  
//������  
public class MyFrame extends JFrame {  
  
    /** 
     * @param args 
     */  
    char charA;  
    public MyFrame(){  
        this.setSize(500,100);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setTitle("my jframe");  
        this.setVisible(true);  
        this.addKeyListener(new MyKeyListener());  
          
          
    }  
      
      
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        new MyFrame();  
    }  
  
}  
//����������  
class MyKeyListener extends KeyAdapter{  
    public void keyPressed(KeyEvent e){  
        char charA=e.getKeyChar();  
        System.out.println("�㰴�ˡ�"+charA+"����");  
    }  
}  