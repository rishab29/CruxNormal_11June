package Lecture13;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(60);
		list.addAt(2, 30);
		list.addAt(3, 40);
		list.addAt(4, 50);
		list.addFirst(5);
		list.display();

		System.out.println(list.getFirst());
		System.out.println(list.getAt(3));
		System.out.println(list.getLast());

		list.removeAt(2);
		list.display();
		list.removeFirst();
		list.removeLast();
		list.display();

		list.addAt(1, 20);
		list.display();

		list.reverseDR();
		list.display();

//		System.out.println(list.mid());
//		System.out.println(list.KthNodeFromEnd(2));
	}

}
