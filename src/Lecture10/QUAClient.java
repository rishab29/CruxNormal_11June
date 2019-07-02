package Lecture10;

public class QUAClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QueuesUsingArrays queue = new QueuesUsingArrays(5);

		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
			displayQueueinfo(queue);
		}
		queue.dequeue();
		queue.dequeue();
		displayQueueinfo(queue);
		queue.enqueue(60);
		queue.enqueue(70);
		displayQueueinfo(queue);
	//	queue.enqueue(70);

	

		while (!queue.isEmpty()) {
			displayQueueinfo(queue);
			queue.dequeue();
		}
//
		queue.dequeue();

	}

	public static void displayQueueinfo(QueuesUsingArrays queue) throws Exception {
		System.out.println("***********************");
		queue.display();
		System.out.println("Front=" + queue.front());
		System.out.println("Size=" + queue.size());
		System.out.println("***********************");
	}

}
