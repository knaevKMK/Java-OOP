package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.Collections;

public interface Field {
    String start(Collection<Player> players);
}
