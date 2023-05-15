package StudentResultManagement.Model;

public class Student {
	private String rollNo;
	private String course;
	    private String branch;   
	   private String name ;
	    private String gender;
	    private String fatherName;
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public String getRollNo() {
			return rollNo;
		}
		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getFatherName() {
			return fatherName;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public Student() {
			super();
		}
		public  Student(String course, String branch, String name, String gender, String fatherName) {
			super();
			this.course = course;
			this.name = name;
			this.branch= branch;
			this.gender = gender;
			this.fatherName = fatherName;
		
			// TODO Auto-generated constructor stub
		}
		
}
