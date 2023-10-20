package 상속_7장;

public class 부모생성자_호출 {

	static class Person {

		public String name;

		public Person(String name) {
			System.out.println("부모 생성자 호출");
			this.name = name;
		}

		public void talk() {
			System.out.println("말하기");
		}

	}

	static class Student extends Person {

		public int age;

		public Student(String name, int age) {
			super(name);
			this.age = age;
		}

		@Override
		public void talk() {
			System.out.println("학생이 말하다");
		}
	}

	public static void main(String[] args) {

		Student student = new Student("홍길동", 20);

		System.out.println(student.name);
		System.out.println(student.age);

		student.talk();

	}

}
