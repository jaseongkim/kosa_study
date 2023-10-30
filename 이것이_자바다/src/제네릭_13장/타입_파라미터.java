package 제네릭_13장;

public class 타입_파라미터 {
	
	static class Person{
		
	}
	
	static class Student extends Person{
		
	}
	
	static class Worker extends Person{
		
	}
	
	static class Applicant<T> {
		
		private T kind;
		
		public Applicant(T kind){
			this.kind = kind;
		}		
		
	}
	
	static class Course{
		
		public static void regiserCourse1(Applicant<?> applicant) {	
			System.out.println(applicant.kind.getClass().getSimpleName() + " 코스 1 등록");
		}
		
		public static void regiserCourse2(Applicant<? extends Student> applicant) {
			System.out.println(applicant.kind.getClass().getSimpleName() + " 코스 2 등록");
		}
		
		public static void regiserCourse3(Applicant<? super Worker> applicant) {
			System.out.println(applicant.kind.getClass().getSimpleName() + " 코스 3 등록");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		Course.regiserCourse1(new Applicant<Person>(new Person()));
		Course.regiserCourse1(new Applicant<Student>(new Student()));
		Course.regiserCourse1(new Applicant<Worker>(new Worker()));
		
//		Course.regiserCourse2(new Applicant<Person>(new Person()));
		Course.regiserCourse2(new Applicant<Student>(new Student()));
//		Course.regiserCourse2(new Applicant<Worker>(new Worker()));
		
		Course.regiserCourse3(new Applicant<Person>(new Person()));
//		Course.regiserCourse3(new Applicant<Student>(new Student()));
		Course.regiserCourse3(new Applicant<Worker>(new Worker()));
		
	}
	

}
