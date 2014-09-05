import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * TODO: Simplified Regular Task TODO: Also if specified time! Can access file
 * that match the created time!
 * 
 * @author FengjiaoJiang
 * 
 */

public class RegularExpressionMatch {
	private static Pattern pattern;
	private static Matcher matcher;
	private static StringBuffer patternString = new StringBuffer();
	//TODO: If I need to all these patterns as "final static here"
	/*
	 * Transform regular expression to a simpler form
	 */
	public static String DecidePatternType(String type, String pattern){
		String resultPattern = "";
		switch(type){
		case "contain":
			resultPattern = ContainsX(pattern);
			break;
			
		case "containF":
			resultPattern = ContainsXForce(pattern);
			break;
			
		case "endup":
			resultPattern = EndUpWithX(pattern);
			break;
			
			default:
				break;
		}
		
		return resultPattern;
	}
	
	public static boolean GiveToPM(String regex, String str){
		pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(str);
		if(matcher.matches())
			return true;
		return false;
	}

	/*
	 * 1. Contains single character or word
	 */
	public static String ContainsX(String regex) {
		if(patternString.toString().length() != 0)
			patternString = new StringBuffer();
		patternString.append(".*");
		patternString.append(regex);
		patternString.append(".*");
		return patternString.toString();
		//regexPattern = ".*" + regex + ".*";
		//return GiveToPM(regexPattern, str);
	}

	/*
	 * Doens't matter if there's distance between these words, as long as they
	 * exist with the string
	 * Example:
	 * GeeksForGeeks:
	 * True: (g, gee, gek, gfr)
	 * False: (z, ze)
	 */
	public static String ContainsXForce(String regex) {
		if(patternString.toString().length() > 0)
			patternString = new StringBuffer();
		
		patternString.append(".*");
//		String regexPattern = "", match = ".*";
//		regexPattern += match;

		for(int i = 0; i < regex.length(); i++){
			patternString.append(String.valueOf(regex.charAt(i)));
			patternString.append(".*");
		}
		
		return patternString.toString();
	}
	

	/*
	 * 2. Contains single character | word & end up with?
	 */
	public static String EndUpWithX(String regex) {
		if(patternString.toString().length() > 0)
			patternString = new StringBuffer();
		
		patternString.append(".*");
		patternString.append(regex);
		patternString.append("$");
		return patternString.toString();
	}


	/*
	 * Main function here for testing
	 */
	public static void main(String[] args) {
		
	}
}
