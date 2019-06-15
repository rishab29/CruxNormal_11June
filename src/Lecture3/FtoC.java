package Lecture3;

public class FtoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int f = 0;
		int fmax = 300;
		while (f <= fmax) {
			int c = (int) ((5.0 / 9) * (f - 32));
			System.out.println(f + "\t" + c);
			f = f + 20;
		}

	}

}
