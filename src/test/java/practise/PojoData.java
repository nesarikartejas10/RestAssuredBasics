package practise;

public class PojoData {
	
	private String name;
	private String age;
	private String grade;
	private String subjects[];
	
	
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
		return subjects;
	}
	public void setSubjects(String[] subArray) {
		this.subjects = subArray;
	}
	
}
