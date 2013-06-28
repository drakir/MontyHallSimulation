package se.rikard.montyhall;

public class Moderator {

    public Door openGoatDoor(ImmutableDoors doors, Door pickedDoor) {
        return doors.without(pickedDoor).aGoatDoor();
    }

}
