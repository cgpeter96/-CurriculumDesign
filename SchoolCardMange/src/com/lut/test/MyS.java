package com.lut.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyS {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://115.159.203.144:3306/Demo;autoReconnect=true;failOverReadOnly=false";
	private String USER="root";
	private String  PWD="chen0326";
	 
	
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		public MyS()
		{
			
			try {
				Class.forName(DRIVER);
				System.out.println("����...");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ʧ��");
				System.out.println(e);
			}
		}
	
	
		
		public void showData(String sql){
			try {
				System.out.println("���Է�������....");
				con=DriverManager.getConnection(URL,"root", "chen0326");
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs!=null){
					while(rs.next())
						for(int i=1;i<rs.getMetaData().getColumnCount();i++)
						{
							System.out.print(rs.getString(i)+" ");
						}
					System.out.println();
				}
			} catch (SQLException e) {
         
				System.out.println("����T^T");
				e.printStackTrace();
			}
		}
	
}
