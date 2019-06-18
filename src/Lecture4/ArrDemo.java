package Lecture4;

public class ArrDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		// System.out.println(arr);
		arr = new int[5];
		//System.out.println(arr);

		//System.out.println(arr[0]);
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		display(arr);

		//System.out.println(arr[0]);
		int i=0,j=2;
		System.out.println(arr[i]+","+arr[j]);
		swap(arr, i, j);
		System.out.println(arr[i]+","+arr[j]);
		
		
	}

	public static void display(int[] arr) {
//		 arr=new int[5];
//		 int[] arr1=new int[10];
//		 int[] arr2=new int[20];		
		 System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int[] arr,int i,int j) {
		arr=new int[5];
		System.out.println(arr[i]+","+arr[j]);
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		System.out.println(arr[i]+","+arr[j]);
	}

}
