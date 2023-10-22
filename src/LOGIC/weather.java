package LOGIC;

import java.lang.Math;

public class weather {
    readJSON rJSON = new readJSON();

    private static volatile weather instance;
    private weather() {}public static weather getInstance(){
        weather result = instance;
        if(result==null)
            synchronized (weather.class) {
                result=instance;
                if (result == null)
                    instance = result = new weather();
            }
        return instance;
    }
    private String currentWeather;
    private int temperature;
    public String getCurrentWeather() {
        return currentWeather;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }







    int snowyMax = rJSON.getConfig("weatherConfig","snowyMax");
    int snowyMin = rJSON.getConfig("weatherConfig","snowyMin");

    public void heatWave(){
        int max = rJSON.getConfig("weatherConfig","heatWaveMax");;
        int min = rJSON.getConfig("weatherConfig","heatWaveMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("heat wave");
    }
    public void sunny(){
        int max = rJSON.getConfig("weatherConfig","sunnyMax");;
        int min = rJSON.getConfig("weatherConfig","sunnyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("sunny");
    }
    public void rainy(){
        int max = rJSON.getConfig("weatherConfig","rainyMax");;
        int min = rJSON.getConfig("weatherConfig","rainyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("rainy");
    }
    public void stormy(){
        int max = rJSON.getConfig("weatherConfig","stormyMax");;
        int min = rJSON.getConfig("weatherConfig","stormyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("stormy");
    }
    public void windy(){
        int max = rJSON.getConfig("weatherConfig","windyMax");;
        int min = rJSON.getConfig("weatherConfig","windyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("windy");
    }
    public void cloudy(){
        int max = rJSON.getConfig("weatherConfig","cloudyMax");;
        int min = rJSON.getConfig("weatherConfig","cloudyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("cloudy");
    }
    public void snowy(){
        int max = rJSON.getConfig("weatherConfig","snowyMax");;
        int min = rJSON.getConfig("weatherConfig","snowyMin");;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("snowy");
    }
}

/*
Soleado: 20°C - 35°C
Lluvioso: 10°C - 25°C
Tormenta: Variará, pero puede estar alrededor de 15°C - 30°C.
Ventisca: -10°C - -30°C o más frío.
Nublado: 15°C - 25°C
Nevando: -5°C - 5°C
 */