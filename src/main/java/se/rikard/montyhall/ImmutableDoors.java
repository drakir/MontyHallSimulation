package se.rikard.montyhall;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImmutableDoors extends AbstractList<Door> {
    private final Random random = new Random();

    private final List<Door> doors;
    private final int numberOfDoors;

    public ImmutableDoors(int numberOfDoors) {
        this.doors = new ArrayList<Door>();
        this.numberOfDoors = numberOfDoors;
        resetDoors();
    }

    private void resetDoors() {
        doors.clear();
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(new Door());
        }
    }

    public ImmutableDoors(List<Door> doors) {
        this.doors = doors;
        numberOfDoors = doors.size();
    }

    public ImmutableDoors shuffle() {
        ImmutableDoors immutableDoors = new ImmutableDoors(this.doors);
        immutableDoors.shuffleDoors();
        return immutableDoors;
    }

    private void shuffleDoors() {
        resetDoors();
        get(randomDoorNumber()).setCar();
    }

    private int randomDoorNumber() {
        return random.nextInt(size());
    }

    public Door theCarDoor() {
        for (Door door : this) {
            if (door.hasCar()) {
                return door;
            }
        }
        return null;
    }

    @Override
    public Door get(int index) {
        return doors.get(index);
    }

    @Override
    public int size() {
        return doors.size();
    }

    public ImmutableDoors without(Door... doors) {
        List<Door> remainingDoors = new ArrayList<Door>(this.doors);
        for (Door door : doors) {
            remainingDoors.remove(door);
        }

        return new ImmutableDoors(remainingDoors);
    }

    public Door randomDoor() {
        return get(randomDoorNumber());
    }

    public Door aGoatDoor() {
        return without(theCarDoor()).randomDoor();
    }
}
