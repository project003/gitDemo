package com.cjc.client;

import java.util.Scanner;

import com.cjc.services.Operations;

public class Test {

	public static void main(String[] args) {
		
		Operations op = new Operations();
		
		int ch;
		Scanner sc1 = new Scanner(System.in);
		do {
		System.out.println("1. Add Course");
		System.out.println("\n2. View Course");
		System.out.println("\n3. Add Faculty");
		System.out.println("\n4. View Faculty");
		System.out.println("\n5. Add Batch");
		System.out.println("\n6. View Batch");
		System.out.println("\n7. Add Student");
		System.out.println("\n8. View Student");
		System.out.println("\n9. Exit");
		System.out.println("Plese enter your choice : ");
		ch = sc1.nextInt();

		
		switch(ch) {
			case 1:
				op.addCourse();
				break;
			
			case 2:
				op.viewCourse();
				break;
				
			case 3:
				op.addFaculty();
				break;
			
			case 4:
				op.viewFaculty();
				break;
			
			case 5:
				op.addBatch();
				break;
				
			case 6:
				op.viewBatch();
				break;
				
			case 7:
				op.addStudent();
				break;
				
			case 8:
				op.viewStudent();
				break;
	
			case 9:
				break;
		}
	
	}while(ch!=9);	
	}
}
