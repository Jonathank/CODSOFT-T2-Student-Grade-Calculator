package studentGradeCalculatorWithOutUsingDataBase;

import java.util.Scanner;

public class StudentGradeCalculator {
/*
 * @ this student grade calculator uses no database 
 */
	public static void main(String[] args) {
	try(Scanner scan = new Scanner(System.in);){
		
		int marks = 0,totalmarks =0,count=0;
		double average;
	
		System.out.println("WELCOME TO\n STUDENT GRADE CALCULATOR");
		System.out.println("ENTER MARKS");
		marks = scan.nextInt();
		totalmarks +=marks;
		count++;
		
		while(true) {
			System.out.println("ADD	MORE	(Y/N)");
			String ans = scan.next();
			if(ans.equalsIgnoreCase("Y")) {
				System.out.println("ENTER MARKS");
				marks = scan.nextInt();
				totalmarks +=marks;
				count++;
			}
			else {
				break;
			}
			
			}//end while
		average = totalmarks/count;
		System.out.println();
		System.out.println("TOTAL SUBJECTS : "+count);
		System.out.println("TOTAL MARKS    : "+totalmarks);
		System.out.println();
		System.out.println("AVERAGE MARKS  : "+average);
		calculateAverage(average);
		}
	
	}
private static void calculateAverage(double average) {
		if(average >= 80.0) {
			System.out.println();
			System.out.println("GRADE          :  FIRST DIVISION");
		}
		else if(average >= 70.0) {
			System.out.println();
			System.out.println("GRADE          :  SECOND DIVISION");
		}
		else if(average >= 60.0) {
			System.out.println();
			System.out.println("GRADE          :  THIRD DIVISION");
		}
		else if(average >= 50.0) {
			System.out.println();
			System.out.println("GRADE          :  FOURTH DIVISION");
		}
		else if(average < 50.0) {
			System.out.println();
			System.out.println("GRADE          :  UNQUALIFIED/ FAILED");
		}
	}
}
