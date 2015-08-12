package backtracking;


/**
 * Not that hard but have to think in this way
 * @author fengjiaojiang
 *
 */
public class SpecificInstance_Tricky {

	public static void specificInstance(int n){
		int[] res = new int[2 * n];
		if(fillInstance(res, n, n))
			for(int i = 0; i < n; i++)
				System.out.print(res[i] + " ");
		else
			System.out.println("not possible");
	}
	
	public static boolean fillInstance(int[] res, int index, int n){
		if(index == 0)
			return true;
		
		for(int i = 0; i < 2 * n - index - 1; i++){
			if(res[i] == 0 && res[i + index - 1] == 0){
				res[i] = res[i + index - 1] = index;
				if(fillInstance(res, index - 1, n))
					return true;
				
				res[i] = res[i + index - 1] = 0;
			}
		}
		return false;
	}
}
