import java.util.*;

public class WordBreak {

	public static boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict.contains(s))
			return true;

		for (int i = 0; i < s.length(); i++) {
			String tmpStr = (String) s.subSequence(0, i);

			if (wordDict.contains(tmpStr)) {
				if (wordBreak(s.substring(i), wordDict))
					return true;
			}
		}
		return false;
	}

	public static boolean wordBreakII(String s, Set<String> wordDict) {
		if (wordDict.contains(s))
			return true;

		boolean[] arr = new boolean[s.length() + 1];
		arr[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(0, i)))
				arr[i] = true;
			else {
				for (int j = 0; j <= i; j++) {
					if (arr[j] && wordDict.contains(s.substring(j, i)))
						arr[i] = true;
				}
			}
		}
		return arr[s.length()];
	}

	public static void main(String[] args) {
		String s = "abcd";
		Set<String> dict = new HashSet<String>(Arrays.asList("a", "abc", "b","cd"));
		s = "leetcode";
		dict = new HashSet<String>(Arrays.asList("leet", "code"));
		System.out.println(wordBreakII(s, dict));

	}
}
