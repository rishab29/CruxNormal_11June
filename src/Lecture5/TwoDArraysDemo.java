package Lecture5;

import java.util.Arrays;

public class TwoDArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr;
		// System.out.println(arr);
//         arr=new int[3][4];
//         System.out.println(arr);
//         System.out.println(arr[0]);
//         System.out.println(arr[1]);
//         
//         System.out.println(arr.length);
//         System.out.println(arr[0].length);
//         display(arr);
//         arr[0][1]=30;
//         display(arr);
//         System.out.println(arr[0][1]);

		// arr=new int[][3];

		arr = new int[3][];
		System.out.println(arr[0]);
		// display(arr);
		arr[0] = new int[5];
		arr[1] = new int[2];
		arr[2] = new int[4];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		display(arr);

		// sorting of an array
		int[] tbs = { 39, 23, 13, 4, 76, 45, 24 };
		Arrays.sort(tbs);
		for (int i = 0; i < tbs.length; i++) {
			System.out.print(tbs[i] + " ");
		}

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

}
