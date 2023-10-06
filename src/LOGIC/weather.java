package LOGIC;

import java.lang.Math;

public class weather {

    //singleton pattern
    private static volatile weather instance;
    private weather() {}
    public static weather getInstance(){
        weather result = instance;
        if(result==null)
            synchronized (weather.class) {
                result=instance;
                if (result == null)
                    instance = result = new weather();
            }
        return instance;
    }



    //============================================================
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

    public void heatWave(){
        int max = 50;
        int min = 35;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("heat wave");
    }
    public void sunny(){
        int max = 40;
        int min = 30;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("sunny");
    }
    public void rainy(){
        int max = 30;
        int min = 10;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("rainy");
    }
    public void stormy(){
        int max = 30;
        int min = 15;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("stormy");
    }
    public void windy(){
        int max = 10;
        int min = -5;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("windy");
    }
    public void cloudy(){
        int max = 25;
        int min = 15;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        currentWeather=("cloudy");
    }
    public void snowy(){
        int max = -35;
        int min = -5;
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