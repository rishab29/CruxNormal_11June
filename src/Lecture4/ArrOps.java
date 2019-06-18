package Lecture4;

import java.util.Scanner;

public class ArrOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = takeInput();
//		display(arr);
//		int[] arr = { 10, 203, 34, 56, 21 };
//		reverse(arr);
//		display(arr);

//		System.out.println(max(arr));
//
//		System.out.println(linearSearch(arr, 100));

		int[] arr = { 50, 40, 30, 20, 10 };
		// System.out.println(binarySearch(arr, 100));
		// bubbleSort(arr);
		//selectionSort(arr);
		
		insertionSort(arr);
		display(arr);
	}

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of an array");
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the element at index " + i);
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void reverse(int[] arr) {

		int beg = 0, end = arr.length - 1;
		while (beg <= end) {
			swap(arr, beg, end);
			beg++;
			end--;
		}
	}

	public static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int linearSearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int data) {
		int beg = 0, end = arr.length - 1;
		while (beg <= end) {
			int mid = (beg + end) / 2;
			if (arr[mid] == data) {
				return mid;
			} else if (arr[mid] > data) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}

		return -1;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			swap(arr, i, min);
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
				swap(arr, j, j - 1);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
