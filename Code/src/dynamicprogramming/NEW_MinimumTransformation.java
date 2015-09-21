package dynamicprogramming;

/**
 * The idea is new but implementation is simple I made the implementation by
 * myself.. so.. I don't know.
 * 
 * @author FengjiaoJiang
 *         http://www.geeksforgeeks.org/transform-one-string-to-another
 *         -using-minimum-number-of-given-operation/
 * 
 */
public class NEW_MinimumTransformation {
	public static int minOperations(String strA, String strB) {
		if (strA.equals(strB))
			return 0;
		int i = strA.length() - 1;
		int j = strB.length() - 1;

		while (i >= 0 && j >= 0 && strA.charAt(i) == strB.charAt(j)) {
			i--;
			j--;
		}
		if (i == 0 && j == 0)
			return 0;

		char tmp = strA.charAt(i);
		strA = String.valueOf(tmp) + strA.substring(0, i)
				+ strA.substring(i + 1);
		return 1 + minOperations(strA.substring(0, i), strB.substring(0, j));
	}

	public static void main(String[] args) {
		String strA = "EACBD", strB = "EABCD";
		System.out.println(minOperations(strA, strB));
	}
}
