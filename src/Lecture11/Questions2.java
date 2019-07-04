package Lecture11;

import java.util.Stack;

public class Questions2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 30, 35, 33, 45, 42, 41 };
		int[] ans = StockSpan(prices);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		int[] arr = { 30, 10, 40, 5, 7, 8 };
		nextGreater(arr);
	}

	public static int[] StockSpan(int[] prices) {
		int[] spans = new int[prices.length];
		spans[0] = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < prices.length; i++) {
			
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				spans[i] = i + 1;
			} else {
				spans[i] = i - stack.peek();
			}
			stack.push(i);
		}

		return spans;
	}

	public static void nextGreater(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				int element = stack.pop();
				System.out.println(element + "=>" + arr[i]);
			}
			stack.push(arr[i]);
		}

		while (!stack.isEmpty()) {
			int element = stack.pop();
			System.out.println(element + "=>" + "-1");
		}
	}

}
