package com.lut.ma;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lut.db.DataBase;

public class SearchPaper extends JFrame {

	private JPanel contentPane;
	private Vector row;
	private Vector col;
	private DefaultTableModel tableModel;
	DataBase db=new DataBase();
	private String num;
	private String name;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SearchPaper(String Num,String na) {
		
		num=Num;
		name=na;
		setTitle(name+"��"+"\u8BBA\u6587\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table=new JTable();
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
		
		col.addElement("���ĺ�");
		col.addElement("��������");
		col.addElement("�ڿ���������");
		col.addElement("�������");
		col.addElement("��������");
		String sql="select Paper.���ĺ�,��������,�ڿ���������,�������,�������� from Paper,SendPaper where Number='"+num+"' and SendPaper.���ĺ�=Paper.���ĺ�";
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
