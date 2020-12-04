package boatRace.models.race;

import boatRace.models.boats.interfaces.Boat;
import boatRace.models.race.interfaces.Race;

import java.util.Collection;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Collection<Boat> boats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Collection<Boat> boats) {
        this.distance = distance;
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.boats = boats;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public Collection<Boat> getBoats() {
        return boats;
    }
}
