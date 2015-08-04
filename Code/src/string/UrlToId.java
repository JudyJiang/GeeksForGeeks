package string;

public class UrlToId {
	static private String map = "abcdefghijklmnopqrstuvwxyzABCDEF" + 
            "GHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	public static long urlToId(String url){
		long dataId = 0;
		for(int i = 0; i < url.length(); i++){
			char c = url.charAt(i);
			if(c >= 'a' && c <= 'z'){
				dataId = dataId * 62 + url.charAt(i) - 'a';
			}
			else if(c >= 'A' && c <= 'Z')
				dataId = dataId * 62 + url.charAt(i) - 'A' + 26;
			else if(c >= '0' && c <= '9')
				dataId = dataId * 62 + url.charAt(i) - '0' + 52;
		}
		
		return dataId;
	}
	
	public static String idToUrl(int id){
		StringBuilder sb = new StringBuilder();
		while(id != 0){
			char c = map.charAt(id % 62);
			sb.append(c);
			id /= 62;
		}
		return sb.reverse().toString();
	}
	
	
	public static void main(String[] args){
		
	}
}
