package se.addskills.ex.day1.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Load file into BufferedReader from class path.
 *
 * @author Tim Mickelson
 */
public class ListLoader {

    /**
     * From file name, read file from class-path into BufferedReader and return.
     *
     * @param fileName Name of file that must be on class-path
     * @return BufferedReader ready for reading file
     */
    public static BufferedReader bufferedReader(String fileName) throws URISyntaxException, IOException {
        URL url = ListLoader.class.getClassLoader().getResource(fileName);
        Path path = Paths.get(url.toURI());
        return Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
    }

}