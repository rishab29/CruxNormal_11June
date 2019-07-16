package Lecture16;

public class GenericLLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList<String> stringlist = new LinkedList<>();
//		stringlist.addLast("A");
//		stringlist.addLast("B");
//		stringlist.addLast("C");
//		stringlist.display();
//		

		LinkedList<Student> slist = new LinkedList<>();
		System.out.println(slist);
		slist.addLast(new Student("A", 10));
		slist.addLast(new Student("B", 20));
		slist.addLast(new Student("C", 30));
		slist.addLast(new Student("D", 40));
		slist.addLast(new Student("E", 50));

		System.out.println(slist);
		System.out.println(slist.find(new Student("C", 40)));

		// slist.display();

	}

	public static class Student {
		String name;
		int rollno;

		public Student(String name, int rollno) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.rollno = rollno;
		}

		public String toString() {
			return "{" + this.name + ":" + this.rollno + "}";
		}

		public boolean equals(Object obj) {
			Student os = (Student) obj;
			return this.name.equals(os.name);
		}
	}

}
