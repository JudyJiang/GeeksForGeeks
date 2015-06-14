public class MultiplyString {
	public static String multiplyString(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] res = new int[num1.length() + num2.length()];
		for (int i = m - 1; i >= 0; i--) {
			int first = num1.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				int second = num2.charAt(j) - '0';
				int tmpRes = first * second;
				int index = i + j + 1;
				res[index] += tmpRes;
			}
		}

		int ten = 0;
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = res[i] + ten;
			ten = 0;
			if (res[i] >= 10) {
				ten = res[i] / 10;
				res[i] %= 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		ten = 0;
		while(ten < res.length && res[ten] == 0)
			ten++;

		while(ten < res.length){
			sb.append(res[ten]);
			ten++;
		}
		if(sb.length() == 0)
			return "0";
		return sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "12344", num2 = "345";
		String res = multiplyString(num1, num2);
		System.out.println(res);
		System.out.println(12344*345);
	}
}
