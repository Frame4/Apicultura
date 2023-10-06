package CONTROL;

import LOGIC.weather;

public class aCControl {


    private static volatile aCControl instance;
    private aCControl() {}
    public static aCControl getInstance(){
        aCControl result = instance;
        if(result==null)
            synchronized (aCControl.class) {
                result=instance;
                if (result == null)
                    instance = result = new aCControl();
            }
        return instance;
    }
    //singleton pattern


    private String capacity="mid";

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


    smokeControl sc = smokeControl.getInstance();
    public void decreaseTemperature(){
        weather weather = LOGIC.weather.getInstance();
        if(capacity.equals("max"))
            setCapacity("mid-high");
        else if(capacity.equals("mid-high"))
            setCapacity("mid");
        else if(capacity.equals("mid"))
            setCapacity("mid-low");
        else if(capacity.equals("mid-low")) {
            setCapacity("min");
            weather.setTemperature(weather.getTemperature()-15);
            sc.setSmokeInRoom(false);//ac at min dissipates smoke
        }
        if (!capacity.equals("min"))
            weather.setTemperature(weather.getTemperature()-15);
    }
    public void increaseTemperature(){
        weather weather = LOGIC.weather.getInstance();
        if(capacity.equals("min"))
            setCapacity("mid-low");
        else if(capacity.equals("mid-low"))
            setCapacity("mid");
        else if(capacity.equals("mid"))
            setCapacity("mid-high");
        else if(capacity.equals("mid-high")) {
            setCapacity("max");
            weather.setTemperature(weather.getTemperature()+15);
            sc.setSmokeInRoom(false);//ac at max dissipates smoke
        }
        if(!capacity.equals("max"))
            weather.setTemperature(weather.getTemperature()+15);
    }

}
