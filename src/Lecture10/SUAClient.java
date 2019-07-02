package Lecture10;

public class SUAClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StacksUsingArrays stack = new StacksUsingArrays(5);

		for (int i = 1; i <= 5; i++) {
			stack.push(i * 10);
			displayStackinfo(stack);
		}
		
		//stack.push(60);
		
		while(!stack.isEmpty()){
			displayStackinfo(stack);
			stack.pop();
		}
		
		stack.pop();
		

	}

	public static void displayStackinfo(StacksUsingArrays stack) throws Exception {
		System.out.println("***********************");
		stack.display();
		System.out.println("Top=" + stack.top());
		System.out.println("Size=" + stack.size());
		System.out.println("***********************");
	}

}
