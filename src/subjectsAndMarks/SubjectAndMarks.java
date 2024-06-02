package subjectsAndMarks;

public class SubjectAndMarks {

	private String stdid;
	private String subject;
	private int marks;
	private String grade;
	private String academicyear;
	private String term;
	
	public SubjectAndMarks(String id) {
		this.setStdid(id);
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}


	/**
	 * @return the academicyear
	 */
	public String getAcademicyear() {
		return academicyear;
	}


	/**
	 * @param academicyear the academicyear to set
	 */
	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}


	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}


	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
}
