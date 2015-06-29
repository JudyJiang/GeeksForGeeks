/*
 * 1. multiple empty space "\\s+"
 * 2. original string null;
 * 3. larger or smaller than Integer.MAX/MIN value
 * 4. sign "+/-"
 * 5. 
 */
public class StringToInteger {
	//merely design, especially how to treat the white space part
	public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        
        int index = 0, sign = 1, size = str.length();
        if(index < size && str.charAt(index) == '+'){
            index++;
        }
        
        else if(index < size && str.charAt(index) == '-'){
            index++;
            sign = -1;
        }
        
        if(index < size && (str.charAt(index) < '0' || str.charAt(index) > '9')){
            return 0;
        }
        double res = 0.0;
        for(int i = index; i < size; i++){
           char c = str.charAt(i);
           if(c >= '0' && c <= '9'){
               res = res * 10 + (c - '0');
           }
           else{
               break;
           }
        }
        
        res *= sign;
        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)res;
    }
}
