package Lecture10;

public class Person {
	public int age;
	public String name;

	// default
	Person() {
		System.out.println("Hello");
	}
//
//	// parametrized
	Person(int myage, String name) {
		this.age = myage;
		this.name = name;
	}


}
