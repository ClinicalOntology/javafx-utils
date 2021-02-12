package org.clinicalontology.javafx.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class FileUtils {

    public static Properties loadPropertiesFromFile(File file) {
        if(file == null || !file.exists()) {
            return null;
        } else if(file.isDirectory()) {
            throw new RuntimeException("Properties file cannot be directory: " + file.getName());
        }
        try (InputStream input = new FileInputStream(file)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Unable to load properties file " + file.getPath(), e);
        }
    }

    public static String readFileIntoString(Path filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath.toFile().getCanonicalPath()), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void persistStringToFile(Path path, String content) {
        if(content == null) {
            return;
        } else {
            try {
                byte[] strToBytes = content.getBytes();
                Files.write(path, strToBytes);
            } catch(Exception e) {
                throw new RuntimeException("Error persisting file", e);
            }
        }
    }
}
