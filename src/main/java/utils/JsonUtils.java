package utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> parsInListObjects(String body, Class<T> tClass){
        ObjectMapper objectMapper = new ObjectMapper();
        Class<T[]> arrayClass;
        T[] objects = null;
        try {
        arrayClass = (Class<T[]>) Class.forName("[L" +  tClass.getName() + ";");
            objects = objectMapper.readValue(body, arrayClass);
        } catch (JsonProcessingException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Arrays.asList(objects);
    }

    public static <T> T jsonStringToObject(String content, Class<T> clazz) {
        T obj = null;
        ObjectMapper objMapper = new ObjectMapper();
        try {
            obj = objMapper.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T jsonFileToObject(String path, Class<T> clazz) {
        T obj = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            obj = objectMapper.readValue(Paths.get(path).toFile(), clazz);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> String modelObjectToString(T object) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Object readJson(String filename) {
        Object object = null;
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            JSONParser jsonParser = new JSONParser();
            jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return object;
    }
}
