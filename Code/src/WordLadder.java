
import java.util.*;

//use graph solution, this requires "BFS"
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord,
			Set<String> wordDict) {
		if(wordDict.size() == 0 || beginWord.equals(endWord))
			return 0;
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		
		wordQueue.add(beginWord);
		distanceQueue.add(1);
		
		while(!wordQueue.isEmpty()){
			String currWord = wordQueue.pop();
			int currDis = distanceQueue.pop();
			if(currWord.equals(endWord))
				return currDis;
			
			
			for(int i = 0; i < currWord.length(); i++){
				/*this must be inside the 'i' for loop not outside
				 * otherwise original charWord is changing. 
				 * */
				char[] currChar = currWord.toCharArray();
				for(char c = 'a'; c <= 'z'; c++){
					currChar[i] = c; //this try any possible changes for character in position 'i'
					           //and add it to the queue if the changed word is in the dictionary.
					String tmp = String.valueOf(currChar);
					if(wordDict.contains(tmp)){
						wordQueue.add(tmp);
						distanceQueue.add(currDis + 1);
						wordDict.remove(tmp);//this is necessary if working from current word is not going 
						//to work by change of character in position 'i', then it won't work for future.  
						//change of character in position 'j', if change 'j' ever goes to this same word 
						//after changing.
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args){
		String start = "hit", end = "cog";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		System.out.println(ladderLength(start, end, wordDict));
	}
}
