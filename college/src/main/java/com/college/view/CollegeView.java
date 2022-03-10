package com.college.view;

import java.util.Scanner;

import com.college.controller.CollegeController;
import com.college.controller.CollegeControllerInterface;

public class CollegeView {

	public static void main(String[] args) {
		
		String s = "y";
		Scanner sc = new Scanner(System.in);
		
		while(s.equals("y")) {
			System.out.println("******** Main Menu **********");
			System.out.println("Press 1 to create profile");
			System.out.println("Press 2 to view profile");
			System.out.println("Press 3 to Delete profile");
			System.out.println("Press 4 to View All Profiles");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			
			CollegeControllerInterface cc = new CollegeController();
			
			switch(ch) {
				case 1:
					cc.createProfile();
					break;
				case 2:
					cc.viewProfile();
					break;
				case 3:
					cc.deleteProfile();
					break;
				case 4:
					cc.viewAllProfiles();
					break;
				default:
					System.out.println("Wrong Choice");
			}
			System.out.println("Press y to continue");
			s = sc.next();
		}
		
	}

}
