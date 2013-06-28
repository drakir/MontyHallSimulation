package se.rikard.montyhall;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class DoorsTest {

    @Test
    public void shouldSetCarInOneDoor() throws Exception {
        Doors doors = new Doors(3).shuffle();
        assertThat(doors, hasItem(aCarDoor()));
    }

    private Door aCarDoor() {
        Door aCarDoor = new Door();
        aCarDoor.setCar();
        return aCarDoor;
    }
}
