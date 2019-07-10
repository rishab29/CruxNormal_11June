package Lecture13;

import Lecture12.LinkedList;

public class StackUsingLL {
	private LinkedList list;

	public StackUsingLL() {
		// TODO Auto-generated constructor stub
		this.list = new LinkedList();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public void push(int element) throws Exception {
		this.list.addFirst(element);
	}

	public int pop() throws Exception {
		return this.list.removeFirst();
	}

	public int top() throws Exception {
		return this.list.getFirst();
	}

	public void display() {
		this.list.display();
	}
}
