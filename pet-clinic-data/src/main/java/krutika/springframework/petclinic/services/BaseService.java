package krutika.springframework.petclinic.services;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
public interface BaseService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deletebyId(ID id);
}
