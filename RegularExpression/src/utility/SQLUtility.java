package utility;

import java.io.*;
import java.util.*;


public class SQLUtility {
	
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
				if(dataEntry.contains("")){
					
				}
				
				if(){
					
				}
			}
			
			list.add(oneResultLine);
		}
		
		return list;
	}
	
	public static void main(String[] args){
		
	}
}
