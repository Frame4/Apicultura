package CONTROL;

import LOGIC.weather;

public class lightsControl {

    private static volatile lightsControl instance;
    private lightsControl() {}
    
    private String capacity="mid";
    private int power=3;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void decreaseLight(){
        switch (capacity) {
            case "max" -> {
                setCapacity("mid-high");
                setPower(4);
            }
            case "mid-high" -> {
                setCapacity("mid");
                setPower(3);
            }
            case "mid" -> {
                setCapacity("mid-low");
                setPower(2);
            }
            case "mid-low" -> {
                setCapacity("min");
                setPower(1);
            }
        }

    }
    public void increaseLight(){
        switch (capacity) {
            case "min" -> {
                setCapacity("mid-low");
                setPower(2);
            }
            case "mid-low" -> {
                setCapacity("mid");
                setPower(3);
            }
            case "mid" -> {
                setCapacity("mid-high");
                setPower(4);
            }
            case "mid-high" -> {
                setCapacity("max");
                setPower(5);
            }
        }
    }

    public static lightsControl getInstance(){
        lightsControl result = instance;
        if(result==null)
            synchronized (lightsControl.class) {
                result=instance;
                if (result == null)
                    instance = result = new lightsControl();
            }
        return instance;
    }
   
}
