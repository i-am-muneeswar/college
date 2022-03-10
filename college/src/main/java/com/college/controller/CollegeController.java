package com.college.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.college.entity.Student;
import com.college.service.CollegeService;
import com.college.service.CollegeServiceInterface;

public class CollegeController implements CollegeControllerInterface {

	public int createProfile() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		System.out.println("Enter password: ");
		String password = sc.next();
		
		System.out.println("Enter email: ");
		String email = sc.next();
		
		System.out.println("Enter address: ");
		String address = sc.next();
		
		Student s = new Student();
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setAddress(address);
		
		CollegeServiceInterface cs = new CollegeService();
		int i = cs.createProfileService(s);
		
		if(i>0) {
			System.out.println("Profile Created for "+name);
		}
		
		else {
			System.out.println("Profile not found");
		}
		return i;

	}

	public void viewProfile() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email: ");
		String email = sc.next();
		
		Student s = new Student();
		s.setEmail(email);
		
		CollegeServiceInterface cs = new CollegeService();
		Student s1 = cs.viewProfileService(s);
		
		if(s1!=null) {
			System.out.println("Student name is "+s1.getName());
			System.out.println("Student password is "+s1.getPassword());
			System.out.println("Student Email is "+s1.getEmail());
			System.out.println("Student Address is "+s1.getAddress());
		}
		
		else {
			System.out.println("No record found");
		}
		
	}

	public void deleteProfile() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email: ");
		String email = sc.next();
		
		Student s = new Student();
		s.setEmail(email);
		
		CollegeServiceInterface cs = new CollegeService();
		int s1 = cs.deleteProfileService(s);
		
		if(s1>0) {
			System.out.println("Profile Deleted");
		}
		
		else {
			System.out.println("could not delete profile");
		}
		
	}

	public void viewAllProfiles() {
		
		CollegeServiceInterface cs = new CollegeService();
		ArrayList<Student> ll = cs.viewAllProfilesService();
		
		System.out.println(ll.size()+" records found in the database");
		
		for(Student s3:ll) {
			System.out.println("******************");
			System.out.println("Name is "+s3.getName());
			System.out.println("Password is "+s3.getPassword());
			System.out.println("Email is "+s3.getEmail());
			System.out.println("Address is "+s3.getAddress());
		}
		
	}

}
