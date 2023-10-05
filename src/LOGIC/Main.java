package LOGIC;

import CONTROL.weatherControl;
import GUI.*;

public class Main {
    public static void main(String[] args) {
        beeMenuUI bM = new beeMenuUI();
        beeCareUI wUI = new beeCareUI();
        //bM.beeMenu();
        weatherControl weatherControl = new weatherControl();
        //weatherControl.startWeather();
        wUI.weatherJPanel();




        
        

    }
}