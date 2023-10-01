package LOGIC;
import GUI.*;
import CONTROL.*;
public class Main {
    public static void main(String[] args) {
        beeInterface bI = new beeInterface();
        weatherUI wUI = new weatherUI();
        //bI.beeMenu();
        //wUI.weatherJPanel();
        weatherControl weatherControl = new weatherControl();
        weatherControl.startWeather();


        
        

    }
}