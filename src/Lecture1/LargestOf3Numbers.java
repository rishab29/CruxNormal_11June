package Lecture1;

public class LargestOf3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10;
		int c = 5;
		
		//int a=100,b=200,c=300;
		
		if(a>=b&&a>=c) {
			System.out.println(a);
		}else {
			if(b>=a&&b>=c) {
				System.out.println(b);
			}else {
				System.out.println(c);
			}
		}
	}

}
