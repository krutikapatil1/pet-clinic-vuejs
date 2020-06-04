package krutika.springframework.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
public abstract class AbstractMapService<T, ID> {

    private Map<ID, T> map = new HashMap<ID, T>();

    Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void deleteByObject(Object object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
