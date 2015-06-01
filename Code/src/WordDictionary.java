import java.util.*;


/*
 * This search word staff usually uses TrieNode
 * Children: List<TrieNode> children = new ArrayList<TrieNode>();
 */

public class WordDictionary {
	
	class TrieNode{
		public char value;
		HashMap<Character, TrieNode> children;
		
		public TrieNode(){
			this.children = new HashMap<Character, TrieNode>();
			//or if initialize HashMap should len = 0 for is Leaf
			//this.children = null;
		}
		public TrieNode(char value){
			this.value = value;
			this.children = new HashMap<Character, TrieNode>();
		}
		
		public boolean isLeaf(){
			//return this.children == null; 
			return this.children.size() == 0;
		}
		
	}
	
	private TrieNode root;
	public WordDictionary(){
		this.root = new TrieNode();
	}
	
	public void addWord(String word){
		if(word == null || word.length() == 0)
			return;
		int len = word.length();
		
		TrieNode tmpRoot = this.root;
		for(int i = 0; i < len; i++){
			char tmp = word.charAt(i);
			if(!tmpRoot.children.containsKey(tmp)){
				tmpRoot.children.put(tmp,  new TrieNode(tmp));
			}
			tmpRoot = tmpRoot.children.get(tmp);
		}
	}
	
	public boolean search(String word){
		return false;
	}
	
	
	public static void main(String[] args){
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		//wd.addWord("nice");
		wd.addWord("boy");
		System.out.println(wd.root.children.size());
		System.out.println(wd.root.children.get('b').children.size());
	}
}
