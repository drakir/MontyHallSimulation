package se.rikard.montyhall;

public class Player {

    public Door pickDoor(Doors doors) {
        return doors.randomDoor();
    }

    public Door chooseOtherDoor(Doors doors, Door pickedDoor, Door goatDoor) {
        return doors.without(pickedDoor, goatDoor).randomDoor();
    }
}
