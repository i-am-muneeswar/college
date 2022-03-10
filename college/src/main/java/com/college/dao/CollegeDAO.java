package com.college.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.college.entity.Student;
import com.college.exception.UserDefinedException;

public class CollegeDAO implements CollegeDAOInterface {

	public int createProfileDAO(Student s) {
		
		int i = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			
			if(s.getName().equals("muni")) {
				throw new UserDefinedException();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getAddress());
			
			i = ps.executeUpdate();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		catch (UserDefinedException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public Student viewProfileDAO(Student s) {
		
		Student s2 = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			PreparedStatement ps = con.prepareStatement("select * from Student where email=?");
			ps.setString(1, s.getEmail());
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);
				
				s2 = new Student();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
				
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return s2;
	}

	public int deleteProfileDAO(Student s) {
		
		int i = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

			PreparedStatement ps=con.prepareStatement("delete from Student where email=?");
			ps.setString(1, s.getEmail());
			
			i = ps.executeUpdate();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public ArrayList<Student> viewAllProfilesDAO() {
		
		Student s2 = null;
		
		ArrayList<Student> ll = new ArrayList<Student>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			PreparedStatement ps = con.prepareStatement("select * from Student");
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);
				
				s2 = new Student();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
				
				ll.add(s2);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}

}
