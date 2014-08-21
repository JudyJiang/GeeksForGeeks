import java.io.File;

/**
 * Personal Utility Function for structure file.
 * @author FengjiaoJiang
 *
 */

/*
 * TODO: Add root structure (startPoint)
 *       Personal Search
 */
public class FileTree {
	public static void FileSearch() {
		String dir = System.getProperty("user.dir");
		FileSearch(dir);
	}

	public static void FileSearch(String path) {
		if (path.contains("~"))
			path = path.replace("~", "/Users/fengjiaojiang");

		File file = new File(path);
		FileStructureSearch(file, 0, 0);
	}
	
	public static void FileSearchRegularMatch(){
		
	}


	public static void FileStructureSearch(File file, int startPoint, int space){
		if(!file.isDirectory() && !file.isHidden()){
			PrintFormat(startPoint, space, "|", "——");
			System.out.println(FormName(file.toString(), "/"));
		}

		else{
			if(!file.isHidden()){
				PrintFormat(startPoint, space, "|", "——");
				System.out.println(FormName(file.toString(), "/"));
				for(int i = 0; i < file.list().length; i++){
					space++;
					FileStructureSearch(new File(file, file.list()[i]), startPoint, space);
					space--;
				}
			}
		}
	}

	public static void PrintFormat(int start, int space, String rootSign, String subSign){
		for(int i = 0; i < start; i++)
			System.out.print(" ");
		System.out.print(rootSign);

		for(int i = 0; i < space; i++)
			System.out.print(subSign);
	}


	public static String FormName(String name, String separator) {

		return name.split(separator)[name.split(separator).length - 1];
	}

	public static void main(String[] args) {
		if (args == null || args.length < 1) {
			FileSearch("~/Downloads");
		}
		
//		else if(args.length > 2 && args[]){
//			
//		}

		else {
			FileSearch(args[0]);
		}
	}
}
