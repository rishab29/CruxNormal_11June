package Lecture8;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(CMP(2, 2, 0, 0));
//		System.out.println(getMP(2, 2, 0, 0));
//		printMP(2, 2, 0, 0, "");
//		System.out.println(getMPWD(2, 2, 0, 0));
//		printMPWD(2, 2, 0, 0, "");
//
//		int n = 5;
//		boolean[][] board = new boolean[n][n];
//		System.out.println(countNQueens(board, 0));

		int[][] arr = { { 0, 0, 9, 0 }, { 0, 0, 9, 0 }, { 9, 0, 0, 0 }, { 0, 9, 0, 0 } };
		printAllPathsWithBomb(arr, 3, 3, 0, 0);

	}

	public static int CMP(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		int count = 0;
		int rcount = CMP(er, ec, cr, cc + 1);
		int dcount = CMP(er, ec, cr + 1, cc);
		count = rcount + dcount;
		return count;
	}

	public static ArrayList<String> getMP(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> hresult = getMP(er, ec, cr, cc + 1);
		ArrayList<String> vresult = getMP(er, ec, cr + 1, cc);

		for (int i = 0; i < hresult.size(); i++) {
			myResult.add("H" + hresult.get(i));
		}

		for (int i = 0; i < vresult.size(); i++) {
			myResult.add("V" + vresult.get(i));
		}

		return myResult;
	}

	public static void printMP(int er, int ec, int cr, int cc, String res) {
		if (er == cr && ec == cc) {
			System.out.println(res);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		printMP(er, ec, cr, cc + 1, res + "H");
		printMP(er, ec, cr + 1, cc, res + "V");
	}

	public static ArrayList<String> getMPWD(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> hresult = getMPWD(er, ec, cr, cc + 1);
		ArrayList<String> vresult = getMPWD(er, ec, cr + 1, cc);
		ArrayList<String> dresult = getMPWD(er, ec, cr + 1, cc + 1);

		for (int i = 0; i < hresult.size(); i++) {
			myResult.add("H" + hresult.get(i));
		}

		for (int i = 0; i < vresult.size(); i++) {
			myResult.add("V" + vresult.get(i));
		}

		for (int i = 0; i < dresult.size(); i++) {
			myResult.add("D" + dresult.get(i));
		}

		return myResult;
	}

	public static void printMPWD(int er, int ec, int cr, int cc, String res) {
		if (er == cr && ec == cc) {
			System.out.println(res);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		printMPWD(er, ec, cr, cc + 1, res + "H");
		printMPWD(er, ec, cr + 1, cc, res + "V");
		printMPWD(er, ec, cr + 1, cc + 1, res + "D");
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				count = count + countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

	public static void printAllPathsWithBomb(int[][] arr, int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			arr[cr][cc] = 1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("*************************************");
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}

		if (arr[cr][cc] == 9) {
			return;
		}
		arr[cr][cc] = 1;
		printAllPathsWithBomb(arr, er, ec, cr, cc + 1);
		printAllPathsWithBomb(arr, er, ec, cr + 1, cc);
		arr[cr][cc] = 0;
	}

}
