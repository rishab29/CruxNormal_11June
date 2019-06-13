package Lecture2;

public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int row = 1;

		while (row <= n) {
			int csp = 1;
			while (csp <= n - row) {
				System.out.print(" ");
				csp++;
			}

			int value = row;
			int cst = 1;
			while (cst <= row) {
				System.out.print(value);
				value++;
				cst++;
			}

			value = value - 2;
			cst = 1;
			while (cst < row) {
				System.out.print(value);
				value--;
				cst++;
			}

			System.out.println();
			row++;
		}

	}

}
