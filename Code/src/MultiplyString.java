
public class MultiplyString {
	public static String multiplyString(String num1, String num2){
		int m = num1.length(), n = num2.length();
		int[] res = new int[num1.length() + num2.length()];
		for(int i = m - 1; i >= 0; i--){
			int first = num1.charAt(i) - '0';
			for(int j = n - 1; j >= 0; j--){
				int second = num2.charAt(j) - '0';
				int tmpRes = first + second;
			}
		}
		return "";
	}
}
