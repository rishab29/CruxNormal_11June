package Lecture4;

import java.util.ArrayList;

public class ArraylistDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();

		list.toString();
		System.out.println(list);
//		
		list.add(10);
		System.out.println(list);
		System.out.println(list.size());
		
		list.add(20);
		System.out.println(list);
		System.out.println(list.size());
		
		list.add(30);
		System.out.println(list);
		System.out.println(list.size());
		
		list.add(40);
		System.out.println(list);
		System.out.println(list.size());
		

//		for (int i = 0; i < 100; i++) {
//			list.add(i);
//		}
//		System.out.println(list);
//		demofun(list);
		
		
		list.set(2, 100);
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		
		System.out.println(list.get(2));
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	public static void demofun(ArrayList<Integer> mylist) {
		System.out.println(mylist);
	}

}
