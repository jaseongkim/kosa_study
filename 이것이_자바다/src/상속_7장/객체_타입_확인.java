package 상속_7장;

public class 객체_타입_확인 {

	public static class Person {
		
		String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		public void work() {
			System.out.println("걷기");
		}
		
	}
	
	public static class Student extends Person {
		
		String studentNo;
		
		public Student(String name, String studentNo) {
			super(name);
			this.studentNo = studentNo;
		}
		
		public void study() {
			System.out.println("공부하기");
		}
		
	}
	
	
	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		
		person.work();
		
		if(person instanceof Student) {
			Student student = new Student("홍길동동", "넘버");
			
			System.out.println("번호 : " + student.studentNo);
			
			student.study();
		}
		
	}
	
	public static void main(String[] args) {
		
		Person person = new Person("홍길동");
		
		Student student = new Student("홍길동동", "넘버");
		
		personInfo(person);
		System.out.println("-------------------------------------------");
		personInfo(student);
		
		
			
		
		
		
		
	}
	
	
	
	

}
