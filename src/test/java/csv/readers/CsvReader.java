package csv.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	/**
	 * Create a List of String arrays given the path to file and delimiter.
	 * @param path to the file as String
	 * @param delimiter within the file as String
	 * @return List of String[] where each String[] is a single line of the file
	 */
	public static List<String[]> csvToListOfArrays(String path, String delimiter) {
		List<String[]> retList = new ArrayList<String[]>();
		String line = "";
		
		try  {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while ( (line = br.readLine()) != null) {
				String[] transaction = line.split(delimiter);
				retList.add(transaction);
			}
			
			br.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
				
		return retList;
	}
	
	/**
	 * Overridden method that besides accepting the path to file and delimiter,
	 * given category as a String, returns the List of String[] that consists of
	 * that category lines only.
	 * @param path to the file as a String
	 * @param delimiter of the .csv file as a String
	 * @param category seeked as a String
	 * @return List of String[] that contains only the lines belonging to the category
	 */
	public static List<String[]> csvToListOfArrays(String path, String delimiter, String category) {
		List<String[]> retList = csvToListOfArrays(path, delimiter);
		
		for (int i = 0; i < retList.size(); i++) {
			String[] temp = retList.get(i);
			if (!temp[4].trim().equalsIgnoreCase(category)) {
				retList.remove(i);
				i--;
			}
		}
		
		return retList;
	}
	
}
