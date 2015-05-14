
public class PlusOne {
	public static int[] plusOne(int[] digits){
		if(digits == null || digits.length <= 0)
			return digits;
		
		int carryOne = 0;
		digits[digits.length - 1] += 1;
		for(int i = digits.length - 1; i >= 0; i--){
			int tmp = digits[i] + carryOne;
			System.out.println(tmp);
			if(tmp < 10){
				digits[i] = tmp;
				carryOne = 0;
				break;
			}
			else{
				digits[i] = tmp % 10;
				carryOne = 1;
			}
		}
		
		if(carryOne != 0){
			int[] newDigits = new int[digits.length + 1];
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			newDigits[0] = carryOne;
			return newDigits;
		}
		return digits;
	}
	public static void main(String[] args){
		int[] digits = {8, 9, 9, 9};
		int[] res = plusOne(digits);
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}
}
