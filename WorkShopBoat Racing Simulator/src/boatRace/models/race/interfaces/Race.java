package boatRace.models.race.interfaces;

import boatRace.models.boats.interfaces.Boat;

import java.util.Collection;

public interface Race {
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Collection<Boat> getBoats();
}
