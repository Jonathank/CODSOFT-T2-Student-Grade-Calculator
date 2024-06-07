package studentGradeCalculatorWithDataBase.Application;

import java.util.Scanner;

import studentGradeCalculatorWithDataBase.databaseUtilities.DataBaseUtilities;
import studentGradeCalculatorWithDataBase.student.Student;
import studentGradeCalculatorWithDataBase.subjectAndMarks.SubjectAndMarks;

public class Application {
	/* Student id are auto generated, there fore
	 * add student first, then you can view the student details
	 * including their auto asigned ids. 
	 * then pick the ids and pass them to where needed 
	 * 
	 * */
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in);){
			while(true) {
			String id,name,gender,year,term,subject,grade = null;
			int marks;
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
				gender = scan.next();
				Student std1 = new Student(name);
				std1.setGender(gender);
				
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
			System.out.println("\t\t\t ALL STUDENTS");
			System.out.println();
			DataBaseUtilities.viewstudents();
			System.out.println();
			System.out.println("..............................................");
			System.out.println();
			break;
		case 3:
			// EX1323100
			System.out.println("Enter Student Id");
			id = scan.next();
			System.out.println("Enter Academic year");
			year = scan.next();
			System.out.println("Enter Term");
			term = scan.next();
			System.out.println("Enter Subject");
			subject = scan.next();
			System.out.println("Enter Marks");
			marks = scan.nextInt();
			
			if(marks < 0 || marks >100) {
				System.out.println("Invalid Marks!");
				System.out.println("Re-Enter Marks");
				marks = scan.nextInt();
			}
			else if(marks >= 80) {
				grade = "A";
			}
			else if(marks >= 75) {
				grade = "B";
			}
			else if(marks >= 65) {
				grade = "C";
			}
			else if(marks >= 55) {
				grade = "D";
			}
			else if(marks >= 50) {
				grade = "E";
			}
			else if(marks < 50) {
				grade = "F";
			}
			
			SubjectAndMarks data = new SubjectAndMarks(id);
			data.setAcademicyear(year);
			data.setTerm(term);
			data.setSubject(subject);
			data.setMarks(marks);
			data.setGrade(grade);
			
			if (!(DataBaseUtilities.isStudentIDExists(id))) {
				
				System.err.println("STUDENT ID DOES NOT EXIST, VIEW STUDENTS FOR REFERENCE");
				System.err.println("PLEASE ENTER VALID STUDENT ID");
				break;
			}
			DataBaseUtilities.addSubjectAndMarks(data);
			System.out.println();
			System.out.println("..............................................");
			System.out.println();
			
			while(add) {
				System.out.println("DO YOU WANT TO CONTINUE?  Y/N");
				System.out.print("ENTER Y OR N :  ");
				String ans = scan.next();
				if(ans.equalsIgnoreCase("Y")) {
					System.out.println("Enter Student Id");
					id = scan.next();
					System.out.println("Enter Academic year");
					year = scan.next();
					System.out.println("Enter Term");
					term = scan.next();
					System.out.println("Enter Subject");
					subject = scan.next();
					System.out.println("Enter Marks");
					marks = scan.nextInt();
					
					if(marks < 0 || marks >100) {
						System.out.println("Invalid Marks!");
						System.out.println("Re-Enter Marks");
						marks = scan.nextInt();
					}
					else if(marks >= 80) {
						grade = "A";
					}
					else if(marks >= 75) {
						grade = "B";
					}
					else if(marks >= 65) {
						grade = "C";
					}
					else if(marks >= 55) {
						grade = "D";
					}
					else if(marks >= 50) {
						grade = "E";
					}
					else if(marks < 50) {
						grade = "F";
					}
					
					SubjectAndMarks data1 = new SubjectAndMarks(id);
					data1.setAcademicyear(year);
					data1.setTerm(term);
					data1.setSubject(subject);
					data1.setMarks(marks);
					data1.setGrade(grade);
					
					if (!(DataBaseUtilities.isStudentIDExists(id))) {
						
						System.err.println("STUDENT ID DOES NOT EXIST");
						System.err.println("ENTER VALID STUDENT ID");
					}
					DataBaseUtilities.addSubjectAndMarks(data1);
					System.out.println();
					System.out.println("..............................................");
					System.out.println();
					
				}else {
					break;
				}
			}
			
			break;
		case 4:
			System.out.println("Enter Student Id");
			id = scan.next();
			System.out.println("Enter Academic year");
			year = scan.next();
			System.out.println("Enter Term");
			term = scan.next();
			
			if (!(DataBaseUtilities.isStudentIDExists(id))) {
				
				System.err.println("STUDENT ID DOES NOT EXIST");
				System.err.println("ENTER VALID STUDENT ID");
			}
			 System.out.println();
			 System.out.println();
			DataBaseUtilities.viewSubjectAndMarks(id, year, term);
			 System.out.println();
			break;
		case 5:
			
				System.out.println("THANK YOU FOR TRUSTING US");
				System.out.println("SYSTEM CLOSE");
				System.exit(0);
			
			break;
		}//end switch
		
		}//end while
		}
	}
}
