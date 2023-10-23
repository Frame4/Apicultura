package LOGIC;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class writeJSON {
    public void saveFarm(Farm farm){
        ArrayList<Hive> hives = farm.getHives();

        JSONObject farmObj = new JSONObject();
        JSONObject hivesObj = new JSONObject();

        for(Hive hive : hives){
            JSONObject hiveObj = new JSONObject();
            hiveObj.put("code",hive.getCode());
            hiveObj.put("beeCount",hive.getBeeCount());
            hiveObj.put("alive",hive.isAlive());
            hiveObj.put("pollinatingProgress",hive.getPollinatingProgress());
            hiveObj.put("isReadyToHarvest",hive.isReadyToHarvest());

            hivesObj.put(hive.getCode(),hiveObj);
        }

        farmObj.put("hives",hivesObj);
        farmObj.put("conformity",farm.getConformity());
        farmObj.put("honeyPotsProduced",farm.getHoneyPotsProduced());

        appendToJson("farm",farmObj);
    }
    public void appendToJson(String name, JSONObject obj){
        try {

            String jsonFile = "src/JSON_files/farm.JSON";
            File file = new File(jsonFile);

            JSONParser parser = new JSONParser();
            JSONObject fileObj;

            if (file.exists() && file.length() != 0)
                fileObj = (JSONObject) parser.parse(new FileReader(jsonFile));
            else
                fileObj = new JSONObject();

            fileObj.put(name,obj);

            // Escribe el JSONArray actualizado en el archivo JSON
            FileWriter fileWriter = new FileWriter(jsonFile);
            fileWriter.write(fileObj.toString());
            fileWriter.close();
            System.out.println("Granja guardada.");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}


