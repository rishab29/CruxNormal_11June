package Lecture13;

public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.isEmpty()) {
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}
		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp;
	}

	public void addAt(int index, int data) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid Index");
		}
		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node node = new Node(data, temp.next);
			temp.next = node;
			this.size++;
		}
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		return this.getNodeAt(index).data;
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		Node rv = this.head;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return rv.data;
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		Node rv = this.tail;
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = this.getNodeAt(this.size - 2);
			temp.next = null;
			this.tail = temp;
		}

		this.size--;
		return rv.data;
	}

	public int removeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index == 0) {
			return this.removeFirst();
		} else if (index == this.size - 1) {
			return this.removeLast();
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node rv = temp.next;
			temp.next = temp.next.next;
			this.size--;
			return rv.data;
		}
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node ln = this.getNodeAt(left);
			Node rn = this.getNodeAt(right);
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tprev = prev;
			Node tcurr = curr;
			prev = curr;
			curr = curr.next;
			tcurr.next = tprev;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {
		this.reversePR(this.head);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (this.tail == node) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}

	public int mid() {
		return this.getMidNode().data;
	}

	private Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public int KthNodeFromEnd(int k) throws Exception {
		if (k <= 0 || k > this.size) {
			throw new Exception("Invalid K");
		}
		Node fast = this.head;
		Node slow = this.head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

//	public void reverseDR() {
//		this.reverseDR(this.head, this.head, 0);
//	}
//
//	private void reverseDR(Node left, Node right, int level) {
//		if (right == null) {
//			return;
//		}
//		reverseDR(left, right.next, level + 1);
//		if (level >= this.size / 2) {
//			int temp = left.data;
//			left.data = right.data;
//			right.data = temp;
//			left = left.next;
//		}
//
//	}

	public void reverseDR() {
		Heapmover left = new Heapmover(this.head);
		this.reverseDR(left, this.head, 0);
	}

	private void reverseDR(Heapmover left, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR(left, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}

	}

	class Heapmover {
		Node node;

		public Heapmover(Node node) {
			// TODO Auto-generated constructor stub
			this.node = node;
		}
	}

}
