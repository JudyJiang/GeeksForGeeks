package string;

public class RecursivePrintSentence {
	public static void printUtil(String[] s1, String[] s2, String[] s3, int i, int j, int k){
		if(i >= s1.length || j >= s2.length || k >= s3.length)
			return ;
		
		System.out.println(s1[i] + " " + s2[j] + " " + s3[k]);
		i++; j++; k++;
		printUtil(s1, s2, s3, i, j, k);
		
	}
	
	public static void main(String[] args){
		String[] s1 = {"You", "We"};
		String[] s2 = {"have", "are"};
		String[] s3 = {"sleep", "eat", "drink"};
		printUtil(s1, s2, s3, 0, 0, 0);
	}
}
