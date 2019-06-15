package Lecture3;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dec = 0;
		int bin = 100000;
		int twopowers = 1;
		while (bin != 0) {
			int rem = bin % 10;
			dec = dec + rem * twopowers;
			twopowers = twopowers * 2;
			bin = bin / 10;
		}

		System.out.println(dec);
	}

}
