package com.college.dao;

import java.util.ArrayList;

import com.college.entity.Student;

public interface CollegeDAOInterface {

	int createProfileDAO(Student s);

	Student viewProfileDAO(Student s);

	int deleteProfileDAO(Student s);

	ArrayList<Student> viewAllProfilesDAO();

}
