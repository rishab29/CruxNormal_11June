package Lecture7;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSS("abc"));
		System.out.println(getSSWAscii("ab"));
		System.out.println(getPermutations("abc"));
		System.out.println(getBoardPath(10, 0).size());

		printSS("abc", "");
		printSSWAscii("ab", "");
		printPermutations("abc", "");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getSS(ros);
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add(recresult.get(i));
			myresult.add(cc + recresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> getSSWAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getSSWAscii(ros);
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add(recresult.get(i));
			myresult.add(cc + recresult.get(i));
			myresult.add((int) cc + recresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult = getPermutations(ros);
		for (int i = 0; i < recresult.size(); i++) {
			String recstring = recresult.get(i);
			for (int j = 0; j <= recstring.length(); j++) {
				String mystring = recstring.substring(0, j) + cc + recstring.substring(j);
				myresult.add(mystring);
			}
		}
		return myresult;

	}

	public static ArrayList<String> getBoardPath(int end, int curr) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> recResult = null;
		ArrayList<String> myresult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPath(end, curr + dice);
			for (int i = 0; i < recResult.size(); i++) {
				myresult.add(dice + recResult.get(i));
			}
		}
		return myresult;
	}

	public static void printSS(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, res);
		printSS(ros, res + cc);
	}

	public static void printSSWAscii(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSSWAscii(ros, res);
		printSSWAscii(ros, res + cc);
		printSSWAscii(ros, res + (int) cc);
	}

	public static void printPermutations(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, res + cc);
		}
	}

}
