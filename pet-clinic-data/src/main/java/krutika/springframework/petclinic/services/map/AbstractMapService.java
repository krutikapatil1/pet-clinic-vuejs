package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.BaseEntity;

import java.util.*;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<Long, T>();

    Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("object cannot be null!");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void deleteByObject(Object object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
