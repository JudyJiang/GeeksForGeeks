import java.util.*;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex + 1);
        
        if(rowIndex < 0){
            return res;
        }
        
        res.add(0, 1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 0; j--){
                if(j == i || j == 0){
                    if(res.size() <= j)
                    	res.add(j, 1);
                    else{
                    	res.set(j, 1);
                    }
                }
                else{
                    int val = res.get(j - 1) + res.get(j);
                    if(res.size() <= j)
                    	res.add(j, val);
                    else
                    	res.set(j,  val);
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		List<Integer> res = getRow(3);
		for(Integer i : res){
			System.out.print(i + " ");
		}
		
		
	}
}
