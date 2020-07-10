package edu0427.spring.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu0427.spring.dao.EmpDAO;
import edu0427.spring.vo.EmpInfo;

public class EmpDAOImpl implements EmpDAO {
	private static String url="localhost";
	private static String user="root";
	private static String password="rootroot";

	@Override
	public List<EmpInfo> getEmpList() {
		List<EmpInfo> empList=new ArrayList<EmpInfo>();
		try {
			//注册成功
//			Class.forName("com.mysql.jbdc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn=(Connection) DriverManager.getConnection(url,user,password);
			Statement stmt=(Statement) conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from emp");
			while(rs.next()) {
				EmpInfo emp =new EmpInfo();//TODO
				empList.add(emp);						
			}
			for(EmpInfo emp:empList) { 
				System.out.println(emp);
			}
			stmt.close();
			conn.close();
	 	}catch(Exception e) { 
	 		e.printStackTrace();
	 	}
		return empList;
	}
		
	

	@Override
	public EmpInfo getById(Integer deptno){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getEmpCount(){
		// TODO Auto-generated method stub
		Integer cnt=0;
		try {
			//注册成功
//			Class.forName("com.mysql.jbdc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn=(Connection) DriverManager.getConnection(url,user,password);
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) as cnt from emp");
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
	
