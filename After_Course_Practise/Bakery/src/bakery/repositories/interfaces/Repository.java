package bakery.repositories.interfaces;

import java.util.Collection;

public interface Repository <T> {
    void add(T model);

    Collection<T> getAll();

}
