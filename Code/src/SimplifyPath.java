import java.util.*;

public class SimplifyPath {
	public static String simplifyPath(String path){
		String[] res = path.split("/");
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		Stack<String> stack = new Stack<String>();
		for(String s : res){
			if(!(s==null || s.length() == 0 || s.equals("."))){
				if(s.equals("..")){
					if(!stack.isEmpty())
						stack.pop();
				}
				else{
					stack.push(s);
				}
			}
		}
		for(int i = 0; i < stack.size(); i++){
			sb.append(stack.get(i));
			if(i != stack.size() - 1)
				sb.append("/");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String path = "/a/./b/../../c/";
		path = "/../";
		//path = "/home//foo/";
		
		String res = simplifyPath(path);
		System.out.println(res);
	}
}
