package CONTROL;

import java.lang.Math;

public class weather {
    private String currentWeather;
    protected int temperature;

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public int getTemperature() {
        return temperature;
    }

    public int sunny(){
        int max = 35;
        int min = 20;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("sunny");
        return temperature;
    }
    public int rainy(){
        int max = 25;
        int min = 10;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("rainy");
        return temperature;
    }
    public int stormy(){
        int max = 30;
        int min = 15;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("stormy");
        return temperature;
    }
    public int windy(){
        int max = 5;
        int min = -15;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("windy");
        return temperature;
    }
    public int cloudy(){
        int max = 25;
        int min = 15;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("cloudy");
        return temperature;
    }
    public int snowy(){
        int max = -35;
        int min = -5;
        int range = max - min + 1;
        temperature = (int)(Math.random() * range) + min;
        setCurrentWeather("snowy");
        return temperature;
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