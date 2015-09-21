package string;

import java.util.*;

public class WordSearchII {
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> res = new LinkedList<String>();
		if (words == null || words.length == 0)
			return res;

		int m = board.length, n = board[0].length;
		for (String word : words) {
			boolean flag = false;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					char[][] tmpBoard = new char[m][n];
					for(int x = 0; x < m; x++){
						for(int y = 0; y < n; y++)
							tmpBoard[x][y] = board[x][y];
					}
					if (findWord(tmpBoard, word, i, j, 0))
						//flag = true;
						res.add(word);
				}
			}

		}
		return res;
	}

	public static boolean findWord(char[][] board, String word, int i, int j,
			int index) {
		if (index >= word.length())
			return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;

		if (board[i][j] == word.charAt(index)) {
			char tmp = board[i][j];
			board[i][j] = '#';
		
			if (findWord(board, word, i + 1, j, index + 1))
				return true;
			if (findWord(board, word, i - 1, j, index + 1))
				return true;

			if (findWord(board, word, i, j + 1, index + 1))
				return true;

			if (findWord(board, word, i, j - 1, index + 1))
				return true;
			board[i][j] = tmp;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> res = findWords(board, words);
		System.out.println(res.size());
		for (String s : res)
			System.out.println(s);
	}
}
