package databaseUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.Student;
import subjectsAndMarks.SubjectAndMarks;

public class DataBaseUtilities {
	static Connection conn = DatabaseConnection.getConnection();
	
	/**
	 * Saves the last id in the database
	 * @param id
	 */
	public static void saveId(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO auto_id (ID_NO) VALUES(?)");
			stmt.setInt(1, id);
			//execute
			stmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Returns the auto id's for the student that was created last
	 * @return id numb
	 */
	public static int getLaststudentID() {
		String sql ="SELECT * FROM auto_id ORDER BY ID_NO DESC LIMIT 1";
		int id = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//Checks if the table is empty
			if(rs.next() == false) {
				id =99;
				
			}
			else {
				 id =rs.getInt(1);
				 
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		id++; //increment by 1
		
		return id;	
	}
	
	//
	public static void addStudent(Student std) {
		try {
			String sql = "INSERT INTO student(studentid,std_name,gender) values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, std.getStdid());
			stmt.setString(2, std.getName());
			stmt.setString(3, std.getGender());
			
			stmt.execute();
			 System.out.println("NEW STUDENT RECORD CREATED");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void viewstudents() {
		try {
			System.out.println("STUDENT ID  " + "       	" +"STUDENT NAME" + "	        " + "GENDER");
			String sql = "SELECT * FROM student";
			Statement stmt = conn.createStatement();
			
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Student std = new Student(rs.getString("studentid"),rs.getString("std_name"));
			std.setGender(rs.getString("gender"));
			
			
			System.out.println("..................|........................|.................");
			System.out.println();
			System.out.println(std.getStdid() + "        	" + std.getName() + "             	 " + std.getGender());
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//
	public static void addSubjectAndMarks(SubjectAndMarks marks) {
		try {
			String sql = "INSERT INTO Subjects_and_Marks(studentID ,Academic_year ,Term ,subject_name,Marks ,Grade) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setString(1, marks.getStdid());
			 stmt.setString(2, marks.getAcademicyear());
			 stmt.setString(3, marks.getTerm());
			 stmt.setString(4, marks.getSubject());
			 stmt.setInt(5, marks.getMarks());
			 stmt.setString(6, marks.getGrade());
			 stmt.execute();
			 
			 System.out.println();
			 System.out.println("ADDED SUCCESSFULLY");
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//
	public static void viewSubjectAndMarks(String id, String year,String term) {
		try {
			String sql = "SELECT * FROM Subjects_and_Marks WHERE STUDENTID = ? AND Academic_year = ? AND Term = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, year);
			stmt.setString(3, term);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			SubjectAndMarks marks = new SubjectAndMarks(rs.getString("studentid"));
			marks.setAcademicyear(rs.getString("Academic_year"));
			marks.setTerm(rs.getString("term"));
			marks.setSubject(rs.getString("subject_name"));
			marks.setMarks(rs.getInt("marks"));
			marks.setGrade(rs.getString("grade"));
			
			System.out.println(marks.getStdid() + " " + marks.getAcademicyear() + " " + marks.getTerm() +
					" " + marks.getSubject() + " "+ marks.getMarks()+ " "+ marks.getGrade());
			
			
		}
		System.out.println("Average Marks "+ getAveragemark(id,year,term));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Double getAveragemark(String id,String year,String term) {
		Double averagemark = 0.0;
		try {
			String sql = "SELECT AVG(marks) As averagemark FROM Subjects_and_Marks WHERE STUDENTID = ? AND Academic_year = ? AND Term = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, year);
			stmt.setString(3, term);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
				
		while(rs.next()) {
			
			System.out.println();
			averagemark = rs.getDouble("averagemark");
			
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return averagemark;
	}
	
public static boolean isStudentIDExists(String id) {
		
        try {
            String checkstmt = "SELECT COUNT(studentid) FROM student WHERE studentid =?";
            PreparedStatement stmt = conn.prepareStatement(checkstmt);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count > 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
	
	
	
}
