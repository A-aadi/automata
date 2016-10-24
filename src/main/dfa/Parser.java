package dfa;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public ArrayList<Map> getParsedJson(String file_path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        String asString = jsonParser.parse(new FileReader(file_path)).getAsString();

        JsonArray parsedJson = (JsonArray) jsonParser.parse(asString);
        ArrayList<Map> maps = new ArrayList<>();
        for (int i = 0; i < parsedJson.size(); i++) {
            HashMap<String, java.lang.Object> obj = new HashMap<>();
            JsonElement jsonElement = parsedJson.get(i);
            Type type = new TypeToken<Map<String, java.lang.Object>>() {
            }.getType();
            Map<String, java.lang.Object> myMap = gson.fromJson(jsonElement, type);
            List<String> l = new ArrayList<>(myMap.keySet());

            obj.put("name", myMap.get("name"));
            obj.put("type", myMap.get("type"));
            obj.put("pass-cases", myMap.get("pass-cases"));
            obj.put("fail-cases", myMap.get("fail-cases"));
            JsonObject tuple = jsonParser.parse(String.valueOf(myMap.get("tuple"))).getAsJsonObject();
            obj.put("states", tuple.get("states"));
            obj.put("alphabets", tuple.get("alphabets"));
            obj.put("delta", tuple.get("delta"));
            obj.put("final-states", tuple.get("final-states"));
            maps.add(obj);
        }
        System.out.println(maps.toString());
        return maps;
    }
}
