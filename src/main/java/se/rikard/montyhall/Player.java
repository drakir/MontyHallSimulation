package se.rikard.montyhall;

public class Player {

    public Door pickDoor(ImmutableDoors doors) {
        return doors.randomDoor();
    }

    public Door chooseOtherDoor(ImmutableDoors doors, Door pickedDoor, Door goatDoor) {
        return doors.without(pickedDoor, goatDoor).randomDoor();
    }
}
