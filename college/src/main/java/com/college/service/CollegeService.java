package com.college.service;

import java.util.ArrayList;

import com.college.dao.CollegeDAO;
import com.college.dao.CollegeDAOInterface;
import com.college.entity.Student;

public class CollegeService implements CollegeServiceInterface {

	public int createProfileService(Student s) {
		
		CollegeDAOInterface cd = new CollegeDAO();
		int i = cd.createProfileDAO(s);
		return i;
	}

	public Student viewProfileService(Student s) {
		
		CollegeDAOInterface cd = new CollegeDAO();
		Student S = cd.viewProfileDAO(s);
		return S;
	}

	public int deleteProfileService(Student s) {
		
		CollegeDAOInterface cd = new CollegeDAO();
		int i = cd.deleteProfileDAO(s);
		return i;
		
	}

	public ArrayList<Student> viewAllProfilesService() {
		
		CollegeDAOInterface cd = new CollegeDAO();
		ArrayList<Student> s = cd.viewAllProfilesDAO();
		return s;
	}


}
