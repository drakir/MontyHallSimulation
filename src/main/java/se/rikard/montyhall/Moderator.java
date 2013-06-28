package se.rikard.montyhall;

public class Moderator {

    public Door openGoatDoor(Doors doors, Door pickedDoor) {
        return doors.without(pickedDoor).aGoatDoor();
    }

}
