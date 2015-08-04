package string;

/**
 * I am so good at this problem
 * @author fengjiaojiang
 *
 */
public class CustomerGetComputer {
	public static int notGetComputers(String s, int k){
		int num = 0, count = 0;
		int[] records = new int[256];
		char prev = ' ';
		for(int i = 0; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(records[tmp] == 0){
				records[tmp] += 1;
				count += 1;
				if(count > k){
					num += 1;
				}
			}
			else{
				records[tmp] -= 1;
				count -= 1;
			}
		}
		return num;
	}
	
	public static void main(String[] args){
		String seq = "ABCBCADEED";
		int k = 1;
		System.out.println(notGetComputers(seq, k));
	}
}
