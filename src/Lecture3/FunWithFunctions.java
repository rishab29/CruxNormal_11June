package Lecture3;

public class FunWithFunctions {
	public static int global = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Hello World");
//		HelloFun();
//		HelloFun();

//		HelloFun();
//		HelloGun();

		// local to function
//		int p = 1000;
//		int r = 10;
//		int t = 1;
//		// System.out.println(si(p, r, t));
//		int ans = si(p, r, t);
//		System.out.println(ans);

//		String name = "Raghav";
//		name = funwithname(name);
//		System.out.println(name);

		int a = 10, b = 20;
		System.out.println(a + "," + b);
		swap(a, b);
		System.out.println(a + "," + b);

//		int a = 10;
//		int b=0;
//		if (a > 9) {
//			b = 20;
//			System.out.println(b);
//		}
//		System.out.println(a);
//		System.out.println(b);

		System.out.println(global);

	}

	public static void HelloFun() {
		HelloGun();
		System.out.println("HelloFun");
	}

	public static void HelloGun() {
		System.out.println("HelloGun");
	}

	public static int si(int p, int r, int t) {
		int si = (p * r * t) / 100;
		return si;
	}

	public static String funwithname(String name) {
		System.out.println(name);
		name = "Aakash";
		return name;
	}

	public static void swap(int a, int b) {
		System.out.println(a + "," + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a + "," + b);
		System.out.println(global);
	}

}
