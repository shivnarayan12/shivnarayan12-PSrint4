package utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    public static String loadJson(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
