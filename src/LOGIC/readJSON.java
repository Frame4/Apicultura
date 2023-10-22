package LOGIC;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class readJSON {
    public int getConfig(String group, String value) {
        try {
            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/JSON_files/config.JSON"));

            JSONObject configGroup = (JSONObject) jsonObject.get(group);
            long configValue = (long) configGroup.get(value);
            return (int) configValue;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
