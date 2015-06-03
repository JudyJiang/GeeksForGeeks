import java.util.*;

public class Trie {
	class TrieNode{
		public char value;
		public HashMap<Character, TrieNode> children;
		public boolean isLeaf;
		
		public TrieNode(){
			this.children = new HashMap<Character, TrieNode>();
			this.isLeaf = false;
		}
		
		public TrieNode(char c){
			this();
			this.value = c;
		}
	}
	
	
	private TrieNode root;
	
	public Trie(){
		this.root = new TrieNode();
	}
	
	public void insert(String word){
		if(word == null || word.length() == 0)
			return;
		int len = word.length();
		TrieNode currRoot = this.root;
		for(int i = 0; i < len; i++){
			char tmp = word.charAt(i);
			if(!currRoot.children.containsKey(tmp)){
				TrieNode node = new TrieNode(tmp);
				currRoot.children.put(tmp, node);
			}
			currRoot = currRoot.children.get(tmp);
			if(i == len - 1)
				currRoot.isLeaf = true;
		}
	}
	
	public boolean search(String word){
		if(word == null || word.length() == 0)
			return true;
		if(this.root == null || this.root.children.size() == 0)
			return false;
		return search(word, this.root.children, 0);
	}
	
	public boolean search(String word, HashMap<Character, TrieNode> children, int start){
		if(start == word.length()){
			if(children.size() == 0)
				return true;
			else
				return false;
		}
		
		char tmp = word.charAt(start);
		if(children.containsKey(tmp)){
			if(start == word.length() - 1 && children.get(tmp).isLeaf)
				return true;
			return search(word, children.get(tmp).children, start + 1);
		}
		else{
			return false;
		}
	}
	
	/*
	 * Another and easier (I think) version of search (since we don't have to consider the '.' pattern)
	 */
	public boolean searchII(String word){
		if(word == null || word.length() == 0)
			return true;
		if(this.root == null || this.root.children.size() == 0)
			return false;
		TrieNode currRoot = this.root;
		for(int i = 0; i < word.length(); i++){
			char tmp = word.charAt(i);
			if(!currRoot.children.containsKey(tmp))
				return false;
			else{
				currRoot = currRoot.children.get(tmp);
			}
		}
		if(!currRoot.isLeaf)
			return false;
		return true;
	}
	
	public boolean startWith(String prefix){
		if(prefix == null || prefix.length() == 0)
			return true;
		if(this.root == null || this.root.children.size() == 0)
			return false;
		
		TrieNode currRoot = this.root;
		for(int i = 0; i < prefix.length(); i++){
			char tmp = prefix.charAt(i);
			if(!currRoot.children.containsKey(tmp))
				return false;
			else
				currRoot = currRoot.children.get(tmp);
		}
		return true;
	}
	
	public static void main(String[] args){
		Trie t = new Trie();
		t.insert("abc");
		System.out.println(t.search("abc"));
		System.out.println(t.search("ab"));
		t.insert("ab");
		System.out.println(t.search("ab"));
		t.insert("ab");
		System.out.println(t.search("ab"));
	}
}


