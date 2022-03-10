package com.college;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.college.controller.CollegeController;
import com.college.controller.CollegeControllerInterface;

public class ControllerTest {
	
	
	CollegeControllerInterface cc = null;
	
	@Before
	public void setUp() throws Exception {
		cc = new CollegeController();
	}

	@After
	public void tearDown() throws Exception {
		cc = null;
	}

	@Test
	public void testCreateProfile() {
		
		int i  = cc.createProfile();
		
		assert i>0:"test case failed to create";
		//fail("Not yet implemented");
	}

}
