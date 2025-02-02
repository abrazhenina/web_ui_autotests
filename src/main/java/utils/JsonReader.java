package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonReader {
    public static JsonObject readJson(String path) {
        Path filePath = Path.of(path);

        String jsonString = "";
        try {
            Log.log().info("Read JsonFile " + filePath);
            jsonString = Files.readString(filePath);
        } catch(IOException e) {
            Log.log().info("IOException while reading JsonFile " + filePath);
            e.printStackTrace();
        }
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        return jsonObject;
    }

    public static String getStringFromJSONArray (JsonArray jsonArray, int num, String key) {
        String data;
        int i = 1;
        for (JsonElement pa : jsonArray) {
            JsonObject jsonObj = pa.getAsJsonObject();
            data = jsonObj.get(key).getAsString();
            if (i == num)
                return data;
            i++;
        }
        return "No data found.";
    }

    public static int getIntFromJSONArray (JsonArray jsonArray, int num, String key) {
        int data;
        int i = 1;
        for (JsonElement pa : jsonArray) {
            JsonObject jsonObj = pa.getAsJsonObject();
            data = jsonObj.get(key).getAsInt();
            if (i == num)
                return data;
            i++;
        }
        return 0;
    }
}