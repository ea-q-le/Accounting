package csv.reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
	
	private static final char DEFAULT_SEPARATOR = ',';
	private static FileWriter writer;
	
	/**
	 * Creates a new .csv file delimited by a comma ',' that contains
	 * the List of String[] passed in. The file is stored in the given
	 * path under the given name.
	 * @param lines to be written to the .csv file as a List of String[]
	 * @param path to the file location as a String
	 * @param fileName of the file as a String
	 */
	public static void writeToCsv(List<String[]> lines, String path, String fileName) {
		StringBuilder sb = new StringBuilder();
		
		try {
			writer = new FileWriter(path + File.separator + fileName + ".csv");
		
			for (String[] eachArray : lines) {
				
				for (int i = 0; i < eachArray.length; i++) {
					if (i == eachArray.length - 1) {
						sb.append(eachArray[i]);
					} else {
						sb.append(eachArray[i]).append(DEFAULT_SEPARATOR);
					}
				}
				sb.append("\n");
			}
		
			writer.append(sb);
			writer.flush();
			writer.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
