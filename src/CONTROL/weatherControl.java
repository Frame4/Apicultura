package CONTROL;

import LOGIC.weather;

import java.util.Random;

public class weatherControl{

    Random random = new Random();
    aCControl ac = aCControl.getInstance();


    public String getWeather(){
        weather weather = LOGIC.weather.getInstance();
        return weather.getCurrentWeather();
    }
    public int getTemperature(){
        weather weather = LOGIC.weather.getInstance();
        return weather.getTemperature();
    }


    public void weatherRandomizer(){
        weather weather = LOGIC.weather.getInstance();

        int randomNumber = random.nextInt(9);
        switch (randomNumber) {// de esta manera no va a pasar de estar soleado a nevar de la nada. Los cambios climáticos tienen sentido.
            case 0:
                if (weather.getCurrentWeather().equals("cloudy"))
                    weather.rainy();
                else
                    weather.cloudy();

                break;
            case 1:
                if (weather.getCurrentWeather().equals("rainy") || weather.getCurrentWeather().equals("windy"))
                    weather.stormy();
                else
                    weather.rainy();
                break;
            case 2:
                weather.windy();
                break;
            case 3:
                weather.cloudy();
                break;
            case 4:
                if (weather.getCurrentWeather().equals("rainy") || weather.getCurrentWeather().equals("stormy") || weather.getCurrentWeather().equals("windy"))
                    weather.snowy();

                break;
            case 5:
                if(weather.getCurrentWeather().equals("sunny"))
                    weather.heatWave();
                break;
            default:
                weather.sunny();
        }
        ac.setCapacity("mid");
    }


}
