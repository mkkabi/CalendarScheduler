package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    public static Stream<String> readFileStream(String filePath) {

        try (Stream<String> lines = Files.lines(Paths.get(filePath),
                Charset.defaultCharset())) {

            lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct().forEach(System.out::println);
            return lines;
        } catch (Exception e) {
        }
        return null;
    }

    public static List<String> readFileString(String filePath) {
        BufferedReader reader;
        String line;
        List<String> lines = new ArrayList<String>();
        try {
//            reader = new BufferedReader(new FileReader(new File(filePath)));
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("IO Exception happened");
        }
        return null;
    }
}
