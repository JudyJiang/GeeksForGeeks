import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class test {
	public static void main(String[] args){
		String s = "comman matching sysmbols ";
		String res = "(man)+";
		Pattern p = Pattern.compile(res);
		Matcher m = p.matcher(s);
		
		while(m.find())
			System.out.println(m.group() + "yes");
	}
}
