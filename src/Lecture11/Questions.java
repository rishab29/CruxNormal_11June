package Lecture11;

public class Questions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DynamicStack stack = new DynamicStack(5);
		DynamicStack helper = new DynamicStack(5);
		for (int i = 1; i <= 5; i++) {
			stack.push(i * 10);
		}
		stack.display();
		reverseStack(stack, helper);
		stack.display();

		DynamicQueue queue = new DynamicQueue();
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
		}

		queue.display();
		reverseQueue(queue);
		queue.display();

	}

	public static void reverseStack(DynamicStack stack, DynamicStack helper) throws Exception {
		
	}

	public static void reverseQueue(DynamicQueue queue) throws Exception {
     
	}

}
