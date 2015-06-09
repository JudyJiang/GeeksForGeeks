package PayAttention;
import java.util.*;


//Long is important!
public class FractionRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator){
		if(numerator == 0)
			return "0";
		
		if(denominator == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		if(numerator < 0 ^ denominator < 0)
			sb.append("-");
		
		long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
		long res = num / den;
		long remain = num % den;
		sb.append(res);
		if(remain == 0)
			return sb.toString();
		
		remain *= 10;
		sb.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		//this is brilliant!, the map contains the duplicate remain and 
		// the result string's position until this duplicate. 
		while(remain != 0){
			if(map.containsKey(remain)){
				int index = map.get(remain);
				// left = sb.substring(0, index);
				//String right = sb.substring(index, sb.length());
				sb.insert(index, "(");
				sb.insert(sb.length(), ")");
				return sb.toString();
			}
			map.put(remain, sb.length());
			res = remain / den;
			sb.append(res);
			remain = (remain % den) * 10;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		int num = 2, den = 1;
		System.out.println(fractionToDecimal(num, den));
	}
}
