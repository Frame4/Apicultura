package LOGIC;

public class Hive {
    private int code;
    private int beeCount;
    private boolean alive;
    private int pollinatingProgress;
    private boolean isReadyToHarvest;

    public Hive(int code, int beeCount) {
        this.code = code;
        this.beeCount = beeCount;
        this.alive=true;
        this.pollinatingProgress = 0;
        this.isReadyToHarvest = false;
    }

    public int getCode() {
        return code;
    }

    public int getBeeCount() {
        return beeCount;
    }

    public void setBeeCount(int beeCount) {
        this.beeCount = beeCount;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getPollinatingProgress() {
        return pollinatingProgress;
    }

    public void setPollinatingProgress(int pollinatingProgress) {
        this.pollinatingProgress = pollinatingProgress;
    }

    public boolean isReadyToHarvest() {
        return isReadyToHarvest;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        isReadyToHarvest = readyToHarvest;
    }



}
