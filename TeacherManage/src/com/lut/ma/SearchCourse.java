package com.lut.ma;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lut.db.DataBase;
import javax.swing.JScrollPane;

public class SearchCourse extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector row;//���������	
	private Vector col;//����
	private DefaultTableModel tableModel;
	DataBase db=new DataBase();
	private String num;
	private String name;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SearchCourse(String Num,String na) {
		num=Num;
		name=na;
		setTitle(na+"�Ŀγ���Ϣ");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table =new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		try {
			showData();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void showData() throws SQLException{
		col=new Vector();
		row=new Vector();
		
		col.addElement("�γ̺�");
		col.addElement("�γ�����");
		col.addElement("�Ͽ�����");
		col.addElement("�Ͽ�ʱ��");
		col.addElement("�Ͽεص�");
		String sql="select CNumber,Course,People,Time,Classroom from Courses,AddCourse where Number='"+num+"' and Cnum=CNumber";
		ResultSet rs=db.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		while(rs.next()){
			Vector r=new Vector();
			for(int i=1;i<=rsmd.getColumnCount();i++)
			     r.addElement(rs.getString(i).trim());
			row.addElement(r);
		}
		tableModel=new DefaultTableModel(row,col);
		table.setModel(tableModel);
		table.repaint();
		table.updateUI();
		table.setSurrendersFocusOnKeystroke(true);
		db.closeAll();
	}


}
