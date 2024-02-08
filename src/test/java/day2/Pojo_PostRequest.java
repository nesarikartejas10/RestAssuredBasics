package day2;

public class Pojo_PostRequest {
	
	String name;
	String age;
	String grade;
	String Subjects[];
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String[] getSubjects() {
		return Subjects;
	}
	public void setSubjects(String[] subjects) {
		Subjects = subjects;
	}

}
