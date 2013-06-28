package se.rikard.montyhall;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Doors extends AbstractList<Door> {
    private final Random random = new Random();

    private final List<Door> doors;
    private final int numberOfDoors;

    /**
     * Create x number of Door's
     */
    public Doors(int numberOfDoors) {
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

    private Doors(List<Door> doors) {
        this.doors = doors;
        numberOfDoors = doors.size();
    }

    /**
     * Resets all the doors and put the car in one of the doors.
     *
     * @return Doors with random car door
     */
    public Doors shuffle() {
        Doors doors = new Doors(this.doors);
        doors.shuffleDoors();
        return doors;
    }

    private void shuffleDoors() {
        resetDoors();
        get(randomDoorNumber()).setCar();
    }

    private int randomDoorNumber() {
        return random.nextInt(size());
    }

    /**
     * The car door
     */
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

    public Doors without(Door... doors) {
        List<Door> remainingDoors = new ArrayList<Door>(this.doors);
        for (Door door : doors) {
            remainingDoors.remove(door);
        }

        return new Doors(remainingDoors);
    }

    public Door randomDoor() {
        return get(randomDoorNumber());
    }

    /**
     * A random goat door
     */
    public Door aGoatDoor() {
        return without(theCarDoor()).randomDoor();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Doors)) {
            return false;
        }

        Doors otherDoors = (Doors) o;
        return new EqualsBuilder().append(otherDoors.doors, this.doors).append(otherDoors.numberOfDoors, this.numberOfDoors).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.doors).append(this.numberOfDoors).toHashCode();
    }
}
