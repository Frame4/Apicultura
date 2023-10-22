package LOGIC;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Hive> hives;//pasar a un vector/arraylist
    private int conformity;
    private int honeyPotsProduced;

    public Farm(ArrayList<Hive> hives) {
        this.hives = new ArrayList<Hive>();
        this.conformity = 100;
        this.honeyPotsProduced = 0;
    }

    public ArrayList<Hive> getHives() {
        return hives;
    }

    public void setHives(ArrayList<Hive> hives) {
        this.hives = hives;
    }

    public int getConformity() {
        return conformity;
    }

    public void setConformity(int conformity) {
        this.conformity = conformity;
    }

    public int getHoneyPotsProduced() {
        return honeyPotsProduced;
    }

    public void setHoneyPotsProduced(int honeyPotsProduced) {
        this.honeyPotsProduced = honeyPotsProduced;
    }


}
