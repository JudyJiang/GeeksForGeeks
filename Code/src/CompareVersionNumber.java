
public class CompareVersionNumber {
	// could be 3.5.4.4 ...
	//Trick is 
	//1.zeros before each number
	//2.zeros at the end;
	//3.use the Integer.parseInt!!
	public static int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int i = 0;
		while(i < s1.length || i < s2.length){
			if(i < s1.length && i < s2.length){
				if(Integer.parseInt(s1[i]) > Integer.parseInt(s2[i]))
					return 1;
				else if(Integer.parseInt(s1[i]) < Integer.parseInt(s2[i]))
					return -1;
			}
			
			else if(i < s1.length){
				if(Integer.parseInt(s1[i]) != 0)
					return 1;
			}
			
			else{
				if(Integer.parseInt(s2[i]) != 0)
					return -1;
			}
			i++;
		}
		return 0;
	}

	public static void main(String[] args) {
		String version1 = "01.11", version2 = "1.10";
		System.out.println(compareVersion(version1, version2));
	}
}
