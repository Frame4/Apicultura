package LOGIC;

import CONTROL.*;
import GUI.*;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main extends Thread{
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    farmControl fc = new farmControl();
    aCControl ac = aCControl.getInstance();
    weather weather = LOGIC.weather.getInstance();
    lightsControl lc = lightsControl.getInstance();
    smokeControl sc = smokeControl.getInstance();
    public Farm testFarm = fc.createFarm(5);//granja de pruebas. Será reemplazada por un json donde se cargaran o se guardaran nuevas

    public static void main(String[] args)  {
        Main thread = new Main();
        thread.start();
        beeCareUI wUI = new beeCareUI();
        wUI.weatherJPanel();
    }
    public void displayInfo(){//información temporal. Será reemplazada en interfaz gráfica.



        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("=====================================");
        System.out.println("    temperature: " + weather.getTemperature() + "C°");
        System.out.println("    weather: " +  weather.getCurrentWeather());
        System.out.println("    A/C power: " + ac.getCapacity());
        System.out.println("    lights power: " + lc.getPower());
        System.out.println("    smoke in room: " + sc.isSmokeInRoom());
        System.out.println("-------------------------------------");
        System.out.println("    conformity level: " + testFarm.getConformity());
        System.out.println("    honey pots harvested: " + testFarm.getHoneyPotsProduced());

    }

    Runnable a = () -> {
        weatherControl wC = new weatherControl();
        wC.weatherRandomizer();
        fc.controlConformityLevel(testFarm,weather.getTemperature(),sc.isSmokeInRoom(),lc.getPower());
        displayInfo();

    };
    public void run(){

        scheduler.scheduleAtFixedRate(a, 0, 10, TimeUnit.SECONDS);

    }
}

/*
    Control según el clima: Las abejas son sensibles a los cambios climáticos, por lo que una de las funciones se encargará de encender calentadores,
    aires acondicionados, luces, entre otras cosas. Recibe el clima y la temperatura actual, retorna alguna de las funciones mencionadas.

	Control de colmenas: Las granjas de apicultura suelen tener muchas colmenas, con esto se supone tener un mejor control y orden sobre las colmenas
	y llevar un control de la miel producida.

	Estrategia: Para esta entrega tengo pensado terminar los controladores del aire acondicionado, luces y el humo, indispensables para el cuidado de las abejas en un entorno cerrado,
	además de la función que se encarga de crear las granjas, las cuales consisten de n cantidad de colmenas. La información de la granja se almacenará en el json, el cual está pensado
	para la entrega final, junto con los detalles finales de la interfaz gráfica. Por el momento se trabajará mayoritariamente en terminal. Adicionalmente,
	se implementará el singleton pattern a las clases de control, pues es necesario que solo exista una instancia de las mismas para todo el programa.

 */