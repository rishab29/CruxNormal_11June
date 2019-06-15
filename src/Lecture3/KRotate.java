package Lecture3;

public class KRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 54632;
		int k = -72;

		int num = n;
		int nod = 0;
		while (num != 0) {
			nod++;
			num = num / 10;
		}
		// System.out.println(nod);
		k = k % nod;
		if (k < 0) {
			k = k + nod;
		}

		int divisor = (int) Math.pow(10, k);
		int rem = n % divisor;
		n = n / divisor;
		int ans = rem * (int) Math.pow(10, nod - k) + n;
		System.out.println(ans);
	}

}
