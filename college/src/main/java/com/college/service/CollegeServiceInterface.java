package com.college.service;

import java.util.ArrayList;

import com.college.entity.Student;

public interface CollegeServiceInterface {

	int createProfileService(Student s);

	Student viewProfileService(Student s);

	int deleteProfileService(Student s);

	ArrayList<Student> viewAllProfilesService();

}
