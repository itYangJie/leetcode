package com.ityang.leetcode;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	 int len = word.length();
         TrieNode cur = root;
         for(int i=0;i<len;i++){
         	if(cur.childs[word.charAt(i)-'a']==null){
         		return false;
         	}
         	cur = cur.childs[word.charAt(i)-'a'];
         }
         
         return cur.hasStr;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	 int len = prefix.length();
         TrieNode cur = root;
         for(int i=0;i<len;i++){
         	if(cur.childs[prefix.charAt(i)-'a']==null){
         		return false;
         	}
         	cur = cur.childs[prefix.charAt(i)-'a'];
         }
         
         return true;
    }
    
    public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("sadfdfsfgfg");
		trie.insert("dsfdfsdf");
		trie.insert("sddsfsfs");
		System.out.println(trie.search("sddsfsf"));
		System.out.println(trie.startsWith("dsfdd"));
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