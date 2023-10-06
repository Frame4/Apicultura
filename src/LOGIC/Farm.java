package LOGIC;

public class Farm {
    private Hive[] hives;
    private int conformity;
    private int honeyPotsProduced;

    public Farm(Hive[] hives) {
        this.hives = hives;
        this.conformity = 100;
        this.honeyPotsProduced = 0;
    }

    public Hive[] getHives() {
        return hives;
    }

    public void setHives(Hive[] hives) {
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
