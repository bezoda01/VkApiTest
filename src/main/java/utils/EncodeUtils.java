package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Stream;

public class EncodeUtils {

    public static String encodeToBase64(byte[] text) {
        return Base64.getEncoder().encodeToString(text);
    }

    public static String encodeFileToString(String path) {
        Path paths = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (Stream stream = Files.lines(paths)) {
            stream.forEach(s -> sb.append(s).append("\n"));

        } catch (IOException ex) {
        }
        return sb.toString();
    }
}
