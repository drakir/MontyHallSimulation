package se.rikard.montyhall;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class DoorsTest {

    @Test
    public void shouldCreateThreeDoors() throws Exception {
        Doors doors = new Doors(3);
        assertThat(doors.size(), is(3));
    }

    @Test
    public void shouldSetCarInOneDoor() throws Exception {
        Doors doors = new Doors(3).shuffle();
        assertThat(doors, hasItem(aCarDoor()));
    }

    @Test
    public void shouldGetTheCarDoor() throws Exception {
        Door door = new Doors(3).shuffle().theCarDoor();
        assertThat(door.hasCar(), is(true));
    }

    @Test
    public void shouldGetAGoatDoor() throws Exception {
        Door door = new Doors(3).shuffle().aGoatDoor();
        assertThat(door.hasCar(), is(false));
    }

    @Test
    public void shouldGetDoorsWithoutCarDoor() throws Exception {
        Doors doors = new Doors(3).shuffle();
        Door carDoor = doors.theCarDoor();
        assertThat(doors.without(carDoor), hasItem(not(carDoor)));
    }

    @Test
    public void shouldEqualIfAllDoorsAreTheSame() throws Exception {
        Doors doors1 = new Doors(3);
        Doors doors2 = new Doors(3);
        assertThat(doors1, equalTo(doors2));
    }

    @Test
    public void shouldNotBeEqualOnDifferentDoorSizes() throws Exception {
        Doors doors1 = new Doors(3);
        Doors doors2 = new Doors(5);
        assertThat(doors1, not(equalTo(doors2)));
    }

    private Door aCarDoor() {
        Door aCarDoor = new Door();
        aCarDoor.setCar();
        return aCarDoor;
    }
}
