package Lecture17;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Heap<Integer> heap = new Heap<>();
//		heap.add(35);
//		heap.add(30);
//		heap.add(25);
//		heap.add(20);
//		heap.add(15);
//		heap.add(10);
//		heap.add(5);
//		heap.add(8);
//		heap.add(12);
//		heap.display();
//		System.out.println("*************");
//		heap.add(45);
//		heap.display();

//		Heap<Student> heap=new Heap<>();
//		heap.add(new Student("A",2,800));
//		heap.add(new Student("B",5,500));
//		heap.add(new Student("C",7,300));
//		heap.add(new Student("D",4,600));
//		heap.add(new Student("E",1,900));	
//		heap.add(new Student("F",8,200));
//		heap.add(new Student("G",6,400));
//		heap.add(new Student("H",3,700));
//		heap.add(new Student("I",9,100));
//		heap.display();
//		System.out.println("************************");
//		heap.remove();
//		heap.display();

		Integer[] arr = { 2, 5, 7, 3, 1, 6 };
		Heap<Integer> heap = new Heap<>(arr, false);
		heap.display();

	}

	public static class Student implements Comparable<Student> {
		String name;
		int rollno;
		int marks;

		Student(String name, int rollno, int marks) {
			this.name = name;
			this.marks = marks;
			this.rollno = rollno;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.marks - o.marks;
		}

		public String toString() {
			return "{name=" + this.name + ", marks=" + this.marks + ", rollno=" + this.rollno + "}";
		}

	}

}
