
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s == null){
            return 0;
        }
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        
        String[] words = s.split("\\s+");
        if(words == null || words.length == 0){
            return 0;
        }
        
        int index = words.length - 1;
        while(index >= 0 && words[index].trim().equals("")){
            index--;
        }
        
        if(index >= 0){
            return words[index].length();
        }
        return 0;
    }
}
