import java.util.*;


/*
 * This search word staff usually uses TrieNode
 * Children: List<TrieNode> children = new ArrayList<TrieNode>();
 */

public class WordDictionary {
	
	class TrieNode{
		public char value;
		boolean isLeaf;
		HashMap<Character, TrieNode> children;
		
		public TrieNode(){
			this.children = new HashMap<Character, TrieNode>();
		}
		public TrieNode(char value){
			this.value = value;
			this.children = new HashMap<Character, TrieNode>();
		}		
	}
	
	private TrieNode root;
	public WordDictionary(){
		this.root = new TrieNode();
	}
	
	/*
	 * Exceeds time limits!
	 */
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
			if(i == len - 1)
				tmpRoot.isLeaf = true;
		}
		
	}
	public boolean search(String word){
		if(this.root == null || this.root.children == null ||
				this.root.children.size() == 0)
			return false;
		return search(word, this.root);
	}
	
	/*
	 * Search exceeds time limits
	 */
	public boolean search(String word, TrieNode root){
		if((word == null || word.length() == 0) && root.isLeaf)
			return true;
		
		if((word == null || word.length() == 0) || root.isLeaf)
			return false;/**
			Problem may also happen when try to make the judge in a recursive call
			but the searchII tries to avoid such judge by making the judge inside the loop
			code happens on "searchII" online 106 and 114
			*/
		
		
		
		char tmp = word.charAt(0);
		if(tmp == '.'){
			for(Character c : root.children.keySet()){
				if(search(word.substring(1), root.children.get(c)))
					return true;
			}/**
			this part might be the problem
			set up a result
			result = search(word.substring(1), root.children.get(c))
			if result == true
			break and return result
			*/
			return false;
		}
		else{
			if(!root.children.containsKey(tmp))
				return false;
			else
				return search(word.substring(1), root.children.get(tmp));
		}
	}
	
	public boolean searchII(String word){
		return searchII(word, this.root.children, 0);//this is better than searchI cause
		//this avoids the problem of worddictionary's empty root, go to children directly
	}
	
	public boolean searchII(String word, HashMap<Character, TrieNode> children, int start){
		if(start == word.length()){
			if(children.size() == 0)
				return true;
			else
				return false;
		}
		
		char c = word.charAt(start);
		if(children.containsKey(c)){
			if(start == word.length() - 1 && children.get(c).isLeaf)
				return true;
			return searchII(word, children.get(c).children, start + 1);
		}
		else if(c == '.'){
			boolean result = false;
			for(Map.Entry<Character, TrieNode> child : children.entrySet()){
				if(start == word.length() - 1 && child.getValue().isLeaf)
					return true;//last is '.' and there's a TrieNode who's a leaf
				if(searchII(word, child.getValue().children, start + 1)){
					result = true;
				}
			}
			return result;
		}
		else{
			return false;
		}
	}
	
	
	public static void main(String[] args){
		WordDictionary wd = new WordDictionary();
//		wd.addWord("a");
//		wd.addWord("ab");
//		System.out.println(wd.search("ab."));
		wd.addWord("at");
		wd.addWord("and");
		wd.addWord("an");
		wd.addWord("add");
		wd.addWord("bat");
		String[] test = {"a",".at","bat",".at","an.", "a.d.","b.", "a.d","."};
		System.out.println(wd.search("a"));
	}
}
