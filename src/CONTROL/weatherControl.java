package CONTROL;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class weatherControl extends Thread{
    weather weather = new weather();
    Random random = new Random();

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);



    public void startWeather(){
        weather.sunny();
        start();
    }

    public void weatherRandomizer(){

        int randomNumber = random.nextInt(8);
        switch (randomNumber) {// de esta manera no va a pasar de estar soleado a nevar de la nada. los cambios climaticos tienen sentido.
            case 0:
                weather.sunny();
                break;
            case 1:
                if (weather.getCurrentWeather().equals("cloudy")) {
                    weather.rainy();
                }else
                    weather.cloudy();

                break;
            case 2:
                if (weather.getCurrentWeather().equals("rainy") || weather.getCurrentWeather().equals("windy")) {
                    weather.stormy();
                }else
                    weather.rainy();
                break;
            case 3:
                weather.windy();
                break;
            case 4:
                weather.cloudy();
                break;
            case 5:
                if (weather.getCurrentWeather().equals("rainy") || weather.getCurrentWeather().equals("stormy") || weather.getCurrentWeather().equals("windy")) {
                    weather.snowy();
                }
                break;
            default:
                weather.sunny();
        }
        System.out.println(weather.getCurrentWeather());

    }

    public void run(){
        scheduler.scheduleAtFixedRate(this::weatherRandomizer, 0, 1, TimeUnit.SECONDS);// debe estar en 1 o 2 minutos pero con 5 segundos se ve más rapido.
    }


}
