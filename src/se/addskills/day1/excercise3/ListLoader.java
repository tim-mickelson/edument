package se.addskills.day1.excercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read file and map to List of LanguageData POJO
 */
public class ListLoader {

	/**
	 * Read file from absolut path and read one line at a time.
	 *
	 * @author Tim Mickelson
	 * @since 03/06/2015
	 * @param filename File name with path
	 * @return List of mapped POJO from file
	 * @throws IOException
	 */
	public static List<LanguageData> LoadListFromFile(String filename) throws IOException {
		List<LanguageData> list = new ArrayList<>();
		Path path = Paths.get(filename);
		
		BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
		String line;
		// Loop over lines and parse
		while ((line = reader.readLine()) != null) {
			// Split by ", " chars
			String[] data = line.split(", ");
			
			LanguageData lData = new LanguageData();
			lData.setName(data[0]);
			lData.setReleaseYear(Integer.parseInt(data[1]));
			lData.setDescription(getDescription(line));
			list.add(lData);
		}
		reader.close();
		return list;
	}

	/**
	 * Get the rest after the second ',' character as description.
	 * @param line Full line from file.
	 * @return Description
	 */
	private static String getDescription(String line) {
		int firstPos = line.indexOf(',',0);
		int secondPos = line.indexOf(',',firstPos+1);
		return line.substring(secondPos+1).trim();
	}  // end function getDescription

}  // end class ListLoader