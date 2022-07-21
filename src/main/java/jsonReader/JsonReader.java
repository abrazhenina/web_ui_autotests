package jsonReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
}