package edu0427.spring.dao.impl;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu0427.spring.dao.DeptDAO;
import edu0427.spring.vo.DeptInfo;

public class DeptDAOImpl implements DeptDAO {
	
	private static String url="localhost";
	private static String user="root";
	private static String password="rootroot";
	public  List<DeptInfo> getDeptList() { 
		List<DeptInfo> deptList=new ArrayList<DeptInfo>();
		try {
			//注册成功
//			Class.forName("com.mysql.jbdc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn=(Connection) DriverManager.getConnection(url,user,password);
			Statement stmt=(Statement) conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from dept");
			while(rs.next()) {
				DeptInfo dept =new DeptInfo(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				deptList.add(dept);						
			}
			for(DeptInfo dept:deptList) { 
				System.out.println(dept);
			}
			stmt.close();
			conn.close();
	 	}catch(Exception e) { 
	 		e.printStackTrace();
	 	}
		return deptList;
	}
	
	@Override
	public DeptInfo getById(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Integer getDeptCount() {
		Integer cnt=0;
		try {
			//注册成功
//			Class.forName("com.mysql.jbdc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn=(Connection) DriverManager.getConnection(url,user,password);
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) as cnt from dept");
			while(rs.next()){ 
				cnt=rs.getInt(1);
				rs.getInt("cnt");
			}
		}catch(Exception e) { 
	 		e.printStackTrace();
	 	}
		// TODO Auto-generated method stub
		return cnt;				
	}
	

}
