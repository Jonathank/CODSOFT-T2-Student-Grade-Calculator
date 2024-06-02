package app;

import java.util.Scanner;

import databaseUtilities.DataBaseUtilities;
import student.Student;

public class Application {
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in);){
			while(true) {
			String id,name,gender;
			boolean add = true;
		System.out.println("WELCOME TO STUDENT GRADE CALCULATION");
		System.out.println("ENTER YOUR OPTION");
		System.out.println();
		System.out.println("1	:	ADD STUDENT");
		System.out.println("2	:	VIEW STUDENT");
		System.out.println("3	:	INPUT SUBJECT AND MARKS");
		System.out.println("4	:	VIEW MARKS GRADE AND AVERAGE");
		System.out.println("5	:	EXIT");
		System.out.println();
		System.out.print("option ");
		int option = scan.nextInt();
		
		switch(option) {
		case 1:
			System.out.print("Enter Student Name	 ");
			name = scan.next();
			System.out.print("Enter Student gender   ");
			gender = scan.next();
			Student std = new Student(name);
			std.setGender(gender);
			
			DataBaseUtilities.addStudent(std);
			System.out.println();
			System.out.println("..............................................");
			System.out.println();
			while(add) {
				System.out.println("DO YOU WANT TO CONTINUE?  Y/N");
				System.out.print("ENTER Y OR N :  ");
				String ans = scan.next();
				if(ans.equalsIgnoreCase("Y")) {
				System.out.print("Enter Student Name	 ");
				name = scan.next();
				System.out.print("Enter Student gender   ");
				Student std1 = new Student(name);
				std.setGender(gender);
				
				DataBaseUtilities.addStudent(std1);
				
				System.out.println();
				System.out.println("..............................................");
				System.out.println();
				}else {
					break;
				}
			}
			break;
		case 2:
			System.out.println("ALL STUDENTS");
			System.out.println();
			DataBaseUtilities.viewstudents();
			System.out.println();
			System.out.println("..............................................");
			System.out.println();
			break;
			
		}//end switch
		
		}//end while
		}
	}
}
