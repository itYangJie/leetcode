package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findWords(char[][] board, String[] words) {

		List<String> res = new ArrayList<>();

		if (board.length == 0 || board[0].length == 0 || words.length == 0)
			return res;
		int rows = board.length;
		int columns = board[0].length;

		TrieNode root = buildTrie(words);

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				dfs(board, res, i, j, root);
		return res;
	}

	private void dfs(char[][] board, List<String> res, int i, int j, TrieNode p) {

		char c = board[i][j];
		p = p.childs[c - 'a'];
		if (c == '*' || p == null)
			return;
		if (p.str != null) {
			res.add(p.str);
			p.str = null;
		}
		board[i][j] = '*';
		if (i >= 1)
			dfs(board, res, i - 1, j, p);
		if (j >= 1)
			dfs(board, res, i, j - 1, p);

		if (i < board.length - 1)
			dfs(board, res, i + 1, j, p);
		if (j < board[0].length - 1)
			dfs(board, res, i, j + 1, p);

		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		TrieNode cur;
		int len;
		for (int i = words.length - 1; i >= 0; i--) {
			cur = root;
			len = words[i].length();
			for (int j = 0; j < len; j++) {
				if (cur.childs[words[i].charAt(j) - 'a'] == null) {
					cur.childs[words[i].charAt(j) - 'a'] = new TrieNode();
				}
				cur = cur.childs[words[i].charAt(j) - 'a'];
			}
			cur.str = words[i];
		}
		return root;
	}

	private class TrieNode {
		TrieNode[] childs = new TrieNode[26];
		String str;
	}
}
