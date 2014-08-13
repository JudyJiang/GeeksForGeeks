import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExamples {
	
	public static void testRegex(String[] strings, String regex){
		for(String string : strings){
			testRegex(string, regex);
		}
	}
	
	public static void testRegex(String string, String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m;

		m = p.matcher(string);
		while (m.find())
			System.out.print(m.group() + "\n");
	}
	
	public static void checkBlinkLine(){
		String[] strings = {" ", /*yes*/
				            "", /*yes*/
				            "commmon", /*no*/
				            "common " /*no*/};
		String regex = "^\\s*$";
		testRegex(strings, regex);
	}
	
	public static void removeSpaceBetweenWord_Comman(){
		String[] strings = {"this is common , and there's no need to worry about it ."};
		String regex = "(\\w)(\\s+)([\\.,])";// (\\s+) map one more white space
		//(\\s+)([\\.,]) This one doesn't include the last character, so merely remove the space between characters and signs.
		System.out.println("this is common , and there's no need to worry about it .".replaceAll(regex, "123"));
		//testRegex(strings, regex);
	}
	
	public static void extractTextBetweenTitles(){
		String string = "<title><body>Java Regex - Tutorial</body></title>";
		String regex = "(<title>)(<body>)(.+?)(</body>)(</title>)";
		System.out.println(string.replaceAll(regex, ""));
		testRegex(string, regex);//m.group(3) will find the Java Regex - Tutorial
	}
	
	public static void negativeLookAhead(){
		String string = "Apple is my favorite food, if not about pear";
		//String regex = "(?!b)(.+?)(\\s+)";
	    String regex = "[aA](?!b)(.+?)(''|\\s+)"; //fail to match the last ..pear...
		testRegex(string, regex);
	}
	
	
	public static void stringWithRegex1(){
		String string = "This is my small example string which I'm going to use for pattern matching";
		System.out.println(string.matches("\\w.*"));//return true if finds the pattern
		String[] splitString = string.split("\\s+");
		System.out.println(splitString.length);
		for(String s : splitString)
			System.out.println(s);
		System.out.println(string.replaceAll("\\s+", "\t"));
	}
	
	
	public static void matchTrueOrYes(String s){
		System.out.println(s.matches("true"));
		System.out.println(s.matches("[tT]rue"));
		System.out.println(s.matches("[tT]rue|[yY]es"));
		System.out.println(s.matches(".*true.*"));//words contain true
	}
	
	public static void isThreeLetters(String s){
		System.out.println(s.matches("(\\w){3}"));
		//can use (\\w){3} or [a-zA-Z]{3}
	}
	
	
	public static void isNoNumberAtBeginning(String s){
		System.out.println(s.matches("^[^\\d].*")); //means should use a number at the begining
		//"^[0-9].*" means should use a number as the beginning.
		//if not number, the "^" should be followed with the thing it wants to start with
		//not start with a number can also be "^[^0-9].*"
	}
	
	
	//check string contains an arbitrary number except b
	public static void isIntersection(String s){
		
	}
	
	public static void main(String[] args){
		isNoNumberAtBeginning("abc");
		isNoNumberAtBeginning("1abcd");
		isNoNumberAtBeginning("a1bcd");
	}
	
}
