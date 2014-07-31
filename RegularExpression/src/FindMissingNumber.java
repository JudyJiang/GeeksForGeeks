
/**
 * N - 1 number from 1 to N, find the missing one.
 * @author fengjiaojiang
 *
 */
public class FindMissingNumber {
	public static int FindMissingNumber(int[] array){
		int sum = 0, size = array.length + 1, result;
		result = (size * (size + 1)) / 2;
		
		for(int i = 0; i < size - 1; i++){
			sum += array[i];
		}
		
		return (result - sum);
	}
	
	//When memory out of limit or n * ( n + 1) / 2 out of Integer.Max
	public static int FindMissingNumberII(int[] array){
		int X = array[0], Y = 1, size = array.length;
		
		for(int i = 1; i < size; i++){
			X ^= array[i];
			Y ^= (i + 1);
		}
		
		Y ^= (size + 1);
		return (X^Y);
	}
	
	public static void main(String[] args){
		int[] array = {4, 2, 5, 1};
		System.out.println(FindMissingNumberII(array));
	}
}
