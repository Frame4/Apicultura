package CONTROL;

import LOGIC.*;

import java.util.Random;

public class farmControl {
    Random random = new Random();

    public Farm createFarm(int hiveCount){//creates a farm initializing an array of hives with its population
        Hive[] hives = new Hive[hiveCount];
        for(int i = 0; i<hiveCount;i++)
            hives[i] = new Hive(i,random.nextInt(40001 - 25000) + 25000);
        return new Farm(hives);
    }

    public void controlConformityLevel(Farm farm, int temperature, boolean smoke, int lights){ //controls the conformity level of the farm.
        Hive[] hives = farm.getHives();

        if(temperature < 10 || temperature > 50){//temperatura muy mala
            farm.setConformity(farm.getConformity()-60);
        }
        else if(temperature < 30 || temperature > 40){//temperatura mala
            farm.setConformity(farm.getConformity()-30);
        }
        else
            if(farm.getConformity()<100)
                farm.setConformity(farm.getConformity()+50);

        if(smoke){//el humo las calma
            farm.setConformity(farm.getConformity()+20);
            for(Hive hive : hives){
                hive.setBeeCount(hive.getBeeCount()+random.nextInt(15001 - 10000) + 10000);
            }
        }

        if(farm.getConformity()<0)//si la conformidad está por debajo de 0 afectará al panal
            for (Hive hive : hives) {
                if(hive.isAlive()) {
                    hive.setBeeCount(hive.getBeeCount() - random.nextInt(15001 - 10000) + 10000);
                    if (hive.getBeeCount() < 0) {
                        hive.setAlive(false);
                        hive.setBeeCount(0);
                    }
                }
            }

        if(temperature<0){//si la temperatura está por debajo de 0 afectará al panal
            for(Hive hive : hives){
                if(hive.isAlive())
                    hive.setBeeCount(hive.getBeeCount() -10000);
                if(hive.getBeeCount()<0)
                    hive.setAlive(false);
            }
        }
        if(farm.getConformity()>100)
            farm.setConformity(100);
        farm.setHives(hives);
    }
    


    public void pollinate(Farm farm){//poliniza según el nivel de conformidad
        Hive[] hives = farm.getHives();
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
        Hive[] hives = farm.getHives();
        for(Hive hive : hives){
            if(hive.isReadyToHarvest()){
                hive.setReadyToHarvest(false);
                farm.setHoneyPotsProduced(farm.getHoneyPotsProduced()+1);
            }
        }
        farm.setHives(hives);
    }

}
