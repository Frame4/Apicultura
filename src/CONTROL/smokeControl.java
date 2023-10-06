package CONTROL;

public class smokeControl {
    private static volatile smokeControl instance;
    private smokeControl() {}
    public static smokeControl getInstance(){
        smokeControl result = instance;
        if(result==null)
            synchronized (smokeControl.class) {
                result=instance;
                if (result == null)
                    instance = result = new smokeControl();
            }
        return instance;
    }
    //singleton pattern

    private boolean smokeInRoom;//ac en min o max elimina el humo

    public boolean isSmokeInRoom() {
        return smokeInRoom;
    }

    public void setSmokeInRoom(boolean smokeInRoom) {
        this.smokeInRoom = smokeInRoom;
    }

    public void smokeBees(){
        setSmokeInRoom(true);
    }

}
