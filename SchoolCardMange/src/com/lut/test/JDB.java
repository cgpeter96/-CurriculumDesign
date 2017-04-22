package com.lut.test;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JDB extends JFrame{
// �������
private JScrollPane scpDemo;
private JTableHeader jth;
private JTable tabDemo;
private JButton btnShow;
// ���췽��
public JDB(){
// �����������ԵĶ���
super("JTable���ݰ�ʾ��");
this.setSize(330,400);
this.setLayout(null);
this.setLocation(100,50);
// �������
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,300,270);
this.btnShow = new JButton("��ʾ����");
this.btnShow.setBounds(10,10,300,30);
// ����ťע�����
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
btnShow_ActionPerformed(ae);
}
});
// ��������뵽������
add(this.scpDemo);
add(this.btnShow);
// ��ʾ����
this.setVisible(true);
}
// �����ťʱ���¼�����
public void btnShow_ActionPerformed(ActionEvent ae){
// ��������������Դ����ʾ���ݵľ��崦��������ע����
	DataBase db=new DataBase();
	if(ae.getSource() instanceof JButton){

String sql = "select * from Student"; 

try{
ResultSet rs = db.executeQuery(sql);
// �����ж�������¼
int count = 0;
while(rs.next()){
count++;
}
rs = db.executeQuery(sql);
// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
Object[][] info = new Object[count][4];
count = 0;

while(rs.next()){
info[count][0] = rs.getString("Number");
info[count][1] = rs.getString("Name");
info[count][2] = rs.getString("Sex");//Integer.valueOf( rs.getInt("age") );
info[count][3] = Integer.valueOf( rs.getInt("Age") );
info[count][4] = rs.getString("College");
count++;
// �����ͷ
String[] title = {"ѧ��","����","�Ա�","����","ѧԺ"};
// ����JTable
this.tabDemo = new JTable(info,title);
// ��ʾ��ͷ
this.jth = this.tabDemo.getTableHeader();
// ��JTable���뵽���������������
this.scpDemo.getViewport().add(tabDemo); 

}
}catch(SQLException e){
	System.out.println(e);
}
}
}
public static void main(String[] args){
new JDB();
}
}
