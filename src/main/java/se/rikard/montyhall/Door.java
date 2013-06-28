package se.rikard.montyhall;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Door {
    private boolean car;

    public void setCar() {
        this.car = true;
    }

    public boolean hasCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Door)) {
            return false;
        }
        return new EqualsBuilder().append(((Door)o).car, this.car).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.car).toHashCode();
    }

    @Override
    public String toString() {
        return "Door{" +
                "car=" + car +
                '}';
    }
}
