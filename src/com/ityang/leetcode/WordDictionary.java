package com.ityang.leetcode;

public class WordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad")) ;//false
		System.out.println(wd.search("bad")) ;// true
		System.out.println(wd.search(".ad")) ;// true
		System.out.println(wd.search("b...")) ;// true
	}

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		int len = word.length();
        TrieNode cur = root;
        for(int i=0;i<len;i++){
        	if(cur.childs[word.charAt(i)-'a']==null){
        		cur.childs[word.charAt(i)-'a'] = new TrieNode();
        	}
        	cur = cur.childs[word.charAt(i)-'a'];
        }
        cur.hasStr = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		
		return dfs(root,word,0);
	}

	private boolean dfs(TrieNode cur, String word, int i) {
		
		if(i==word.length())
			return cur.hasStr;
		
		char c = word.charAt(i);
		if(c!='.'){
			if(cur.childs[c-'a']!=null)
				return dfs(cur.childs[c-'a'],word,i+1);
			else
				return false;
		}else{
			for(int j=0;j<26;j++){
				if(cur.childs[j]!=null && dfs(cur.childs[j],word,i+1))
					return true;
			}
			return false;
		}
		
	}
	
	class TrieNode {
		// Initialize your data structure here.
		boolean hasStr;
		TrieNode[] childs;

		public TrieNode() {
			childs = new TrieNode[26];
		}
	}
}

