package string;

import java.util.*;

public class PlaceSpace_FengjiaoJiang {
	public static List<String> placeSpace(String s) {
		List<String> res = new LinkedList<String>();
		Set<String> set = produce(s, 0);
		res.addAll(set);
		return res;
	}

	public static Set<String> produce(String s, int level) {
		if (level == s.length()) {
			Set<String> set = new HashSet<String>();
			set.add(s);
			return set;
		}

		Set<String> prev = produce(s, level + 1);
		Set<String> curr = new HashSet<String>();
		for (String str : prev) {
			if (!curr.contains(str))
				curr.add(str);
			for (int i = 1; i < str.length(); i++) {
				String s1 = str.substring(0, i);
				String s2 = str.substring(i);
				if (!curr.contains(s1))
					curr.add(s1);
				if (!curr.contains(s2))
					curr.add(s2);
			}
		}
		return curr;
	}

	public static void main(String[] args) {
		String s = "ABC";
		List<String> res = placeSpace(s);
		System.out.println(res.size());
		for (String str : res)
			System.out.println(str);

	}
}
