package string;

public class CompareVersions {
	public static int compareVersion(String s1, String s2){
		String[] v1 = s1.split("\\.");
		String[] v2 = s2.split("\\.");
		int size = v1.length > v2.length ? v2.length : v1.length;
		for(int i = 0; i < size; i++){
			String tmp1 = v1[i].trim().replaceFirst("^0+(?!$)", "").replaceAll("0*$", "");
			String tmp2 = v2[i].trim().replaceFirst("^0+(?!$)", "").replaceAll("0*$", "");
			if(tmp1.compareTo(tmp2) != 0)
				return tmp1.compareTo(tmp2) > 0 ? 1 : -1;
		}
		
		if(v1.length == v2.length){
			return 0;
		}
		
		else{
			int len = v1.length > v2.length ? v1.length : v2.length;
			String[] remain = v1.length > v2.length ? v1 : v2;
			for(int i = size; i < len; i++){
				String tmp = remain[i];
				tmp = tmp.trim().replaceFirst("^0+(?!$)", "").replaceAll("0*$", "");
				if(!tmp.equals(""))
					return v1.length > v2.length ? 1 : -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String s1 = "00000";
		String s2 = "2.50000";
		String s = s1.replaceFirst("^0+(?!$)", "");
		s = s.replaceAll("0*$", "");
		System.out.println(s);
	}
}
