package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonReader {
    public static JsonObject readJson(String path) throws IOException {
        Path filePath = Path.of(path);

        String jsonString = "";
        try {
            jsonString = Files.readString(filePath);
        } catch(IOException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        return jsonObject;
    }

    public static JsonArray getJSONArrayFromJSONObj (JsonObject jsonObject, String key) {
        JsonArray jsonArray = null;
        try {
            jsonArray = (JsonArray) jsonObject.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static String getJSONObjFromJSONARRArray (JsonObject jsonObject, String key) {
        return null;
    }
}