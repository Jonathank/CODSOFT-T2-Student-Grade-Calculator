/**
 * 
 */
package student;

import databaseUtilities.DataBaseUtilities;

/**
 * @author USER
 *
 */
public class Student {

	private String stdid;
	private String name;
	private String gender;
	
	private static int autoid;
	
	//inserts to db
	public Student(String name) {
		this.name = name;
		autoid = DataBaseUtilities.getLaststudentID();
		DataBaseUtilities.saveId(autoid);
		
		if(autoid<=999) {
			String idSt = "EX1323"+autoid;
			this.stdid = idSt;	
		}
		else if(autoid >= 1000) {
			String idSt = "EX132"+autoid;
			this.stdid = idSt;
		}
		else if(autoid >= 10000) {
			String idSt = "EX13"+autoid;
			this.stdid = idSt;
		}
		else if(autoid >= 100000) {
			String idSt = "EX1"+autoid;
			this.stdid = idSt;
		}
		else if(autoid >= 1000000) {
			String idSt = "EX"+autoid;
			this.stdid = idSt;
		}
	}
	
	//retrieves from db
	public Student(String id,String name) {
		this.stdid = id;
		this.name = name;
	}
	
	
	
	/**
	 * @return the stdid
	 */
	public String getStdid() {
		return stdid;
	}
	/**
	 * @param stdid the stdid to set
	 */
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
