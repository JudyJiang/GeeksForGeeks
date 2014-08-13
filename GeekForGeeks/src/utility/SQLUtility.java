package utility;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SQLUtility {
	
	private static Pattern timePattern = Pattern.compile(
			"(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)");
	private static Matcher matcher;
	
	public static List<String> readTextFile(String SQLFilePath) 
			throws IOException{
		List<String> list = new ArrayList<String>();
		File file = new File(SQLFilePath);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line;
		String oneResultLine;
		while((line = br.readLine()) != null){
			oneResultLine = "";
			/**
			 * Time processing
			 * 1. First tokenize line by line;
			 * 2. Then tokenize one line by ",";
			 * 3. For now just split by "//" but in the future use regex
			 * 
			 */
			
			String[] dataEntries = line.split(",");
			for(String dataEntry : dataEntries){
				if(dataEntry.replace(" ", "").length() == 0){
					//System.out.println("yes, fixed here");
					continue;
				}
				matcher = timePattern.matcher(dataEntry);
				if(matcher.find()){
					dataEntry = matcher.group(3) + "-" + matcher.group(1) + 
							                       "-" + matcher.group(2);
				}
				
				if(!oneResultLine.equals("")){
					oneResultLine += ","; /*just one SQL record indicator.*/
 				}
				
				
				oneResultLine += dataEntry;
			}

			//System.out.println(oneResultLine + "9");
			list.add(oneResultLine);
		}
		
		return list;
	}
	
	public static void WriteBackToFile(List<String> contents, 
			                        String writeToFilePath) throws IOException{
		File file = new File(writeToFilePath);
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(String content : contents){
			bw.write(content + "\n");
		}
		bw.close();
	}
	
	public static void main(String[] args){
		String filePath = "/Users/fengjiaojiang/Downloads/" +
				"DataAPIPriceInput.txt";
		try {
			List<String> entries = readTextFile(filePath);
			WriteBackToFile(entries, "/Users/fengjiaojiang/Downloads/" +
					                 "DataAPIPriceInput.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}














