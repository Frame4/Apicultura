package LOGIC;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public Farm loadFarm(){
        ArrayList<Hive> hives = new ArrayList<>();
        long code;
        boolean alive;
        long pollinatingProgress;
        long beeCount;
        boolean isReadyToHarvest;
        long conformity;
        long honeyPotsProduced;

        try{
            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/JSON_files/farm.JSON"));


            JSONObject farmObj = (JSONObject) jsonObject.get("farm");
            JSONObject hivesObj = (JSONObject) farmObj.get("hives");



            for(int i = 1; i < hivesObj.size() ; i++){
                JSONObject hiveObj = (JSONObject) hivesObj.get(Integer.toString(i));
                code = (long) hiveObj.get("code");
                alive = (boolean) hiveObj.get("alive");
                pollinatingProgress = (long) hiveObj.get("pollinatingProgress");
                beeCount = (long) hiveObj.get("beeCount");
                isReadyToHarvest = (boolean) hiveObj.get("isReadyToHarvest");

                Hive hive = new Hive((int)code,(int)beeCount);
                hive.setAlive(alive);
                hive.setPollinatingProgress((int)pollinatingProgress);
                hive.setReadyToHarvest(isReadyToHarvest);

                hives.add(hive);
            }

            conformity = (long) farmObj.get("conformity");
            honeyPotsProduced = (long) farmObj.get("honeyPotsProduced");

            Farm farm = new Farm(hives);
            farm.setConformity((int)conformity);
            farm.setHoneyPotsProduced((int)honeyPotsProduced);
            System.out.println("Granja cargada.");
            return farm;
        }catch (IOException | ParseException e) {
            e.printStackTrace();
            System.out.printf("No se ha podido leer el archivo.");
        }
        return null;
    }

    public void openFile(String archive){
        try {
            // Ruta al archivo que deseas abrir
            File fileToOpen = new File(archive); // Reemplaza con la ruta de tu archivo

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (fileToOpen.exists()) {
                    desktop.open(fileToOpen);
                } else {
                    System.out.println("El archivo no existe.");
                }
            } else {
                System.out.println("La funcionalidad Desktop no está soportada en este entorno.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String hivesInfo(Farm farm){
        ArrayList<Hive> hives = farm.getHives();
        StringBuilder info = new StringBuilder("Hives info");
        int i=0;
        for(Hive hive:hives){
            info.append("\ncode: ").append(hive.getCode());
            info.append("\nbeeCount: ").append(hive.getBeeCount());;
            info.append("\nalive: ").append(hive.isAlive());;
            info.append("\npollinatingProgress: ").append(hive.getPollinatingProgress());;
            info.append("\nisReadyToHarvest: ").append(hive.isReadyToHarvest());;
            info.append("\n");
        }
        return info.toString();
    }
}