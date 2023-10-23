package CONTROL;

import LOGIC.Farm;
import LOGIC.Hive;
import LOGIC.readJSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class farmControl  {



    Random random = new Random();
    readJSON rJSON = new readJSON();
    //valores de configuración desde config. JSON;
    int maxBeeAdding = rJSON.getConfig("farmConfig","maxBeeAdding");
    int minBeeAdding = rJSON.getConfig("farmConfig","minBeeAdding");
    int heavyImpactMax = rJSON.getConfig("farmConfig","heavyImpactMax");
    int heavyImpactMin = rJSON.getConfig("farmConfig","heavyImpactMin");;
    int lightImpactMax = rJSON.getConfig("farmConfig","lightImpactMax");;
    int lightImpactMin = rJSON.getConfig("farmConfig","lightImpactMin");;




    public Farm createFarm(){//creates a farm initializing an array of hives with its population
        ArrayList<Hive> hives = new ArrayList<Hive>();
        return new Farm(hives);
    }
    public Farm addHives(Farm farm){
        ArrayList<Hive> hives = farm.getHives();

        hives.add(new Hive(getLastHiveCode(farm)+1,random.nextInt(maxBeeAdding - minBeeAdding) + minBeeAdding));
        farm.setHives(hives);
        return farm;
    }

    public int getLastHiveCode(Farm farm){
        ArrayList<Hive> hives = farm.getHives();
        ArrayList<Integer> codes = new ArrayList<Integer>();
        for(Hive hive : hives){
            codes.add(hive.getCode());
        }

        return findMax(codes);
    }
    public static Integer findMax(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        return Collections.max(list);
    }

    public Hive killBees(Hive hive){
        hive.setBeeCount(hive.getBeeCount() - random.nextInt(maxBeeAdding - minBeeAdding) + minBeeAdding);
        if (hive.getBeeCount() < 0) {
            hive.setAlive(false);
            hive.setBeeCount(0);
        }
        return hive;
    }
    public Hive addBees(Hive hive){
        hive.setBeeCount(hive.getBeeCount() + random.nextInt(maxBeeAdding - minBeeAdding) + minBeeAdding);
        return hive;
    }
    public int heavyImpactOnHive(){
        return random.nextInt(heavyImpactMax - heavyImpactMin) + heavyImpactMin;
    }
    public int lightImpactOnHive(){
        return random.nextInt(lightImpactMax - lightImpactMin) + lightImpactMin;
    }
    public void controlConformityLevel(Farm farm, int temperature, boolean smoke, int lights){ //controls the conformity level of the farm.
        ArrayList<Hive> hives = farm.getHives();

        if(temperature < 10 || temperature > 50){//temperatura muy mala
            farm.setConformity(farm.getConformity()-heavyImpactOnHive());
        }
        else if(temperature < 30 || temperature > 40){//temperatura mala
            farm.setConformity(farm.getConformity()-lightImpactOnHive());
        }
        else
            if(farm.getConformity()<100)
                farm.setConformity(farm.getConformity()+heavyImpactOnHive());

        if(smoke){//el humo las calma
            farm.setConformity(farm.getConformity()+lightImpactOnHive());
            for (Hive hive : hives)
                hive = addBees(hive);
        }

        if(farm.getConformity()<0)//si la conformidad está por debajo de 0 afectará al panal
            for (Hive hive : hives) {
                if(hive.isAlive()) {
                    hive = killBees(hive);
                }
            }

        if(temperature<0){//si la temperatura está por debajo de 0 afectará al panal
            for(Hive hive : hives){
                if(hive.isAlive())
                    hive = killBees(hive);
            }
        }
        if(farm.getConformity()>100)
            farm.setConformity(100);
        farm.setHives(hives);
    }
    


    public void pollinate(Farm farm){//poliniza según el nivel de conformidad
        ArrayList<Hive> hives = farm.getHives();
        for(Hive hive : hives) {
            if(farm.getConformity()>65) {
                if(hive.getPollinatingProgress()<100)
                    hive.setPollinatingProgress(hive.getPollinatingProgress() + 25);
                else
                    hive.setPollinatingProgress(100);
            }else{
                if (hive.getPollinatingProgress() < 100)
                    hive.setPollinatingProgress(hive.getPollinatingProgress() + 10);
                else
                    hive.setPollinatingProgress(100);
            }
        }
        farm.setHives(hives);
    }

    public void harvest(Farm farm){
        ArrayList<Hive> hives = farm.getHives();
        for(Hive hive : hives){
            if(hive.isReadyToHarvest()){
                hive.setReadyToHarvest(false);
                farm.setHoneyPotsProduced(farm.getHoneyPotsProduced()+1);
            }
        }
        farm.setHives(hives);
    }
}
