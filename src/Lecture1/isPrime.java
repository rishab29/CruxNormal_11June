package Lecture1;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 45;
		int Div = 2;
		while (Div < n) {
			if (n % Div == 0) {
				System.out.println("Not Prime");
				return;
			}
			Div++;
		}
		System.out.println("Prime");
	}

}
