package Lecture2;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int nst = 1;
		int row = 1;

		while (row <= n) {
			int cst = 1;
			while (cst <= nst) {
				if (cst % 2 == 1) {
					System.out.print(row);
				} else {
					System.out.print("*");
				}
				cst++;
			}

			System.out.println();
			row++;
			nst = nst + 2;
		}
	}

}
