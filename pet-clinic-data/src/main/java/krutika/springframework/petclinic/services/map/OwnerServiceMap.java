package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Owner;
import krutika.springframework.petclinic.services.BaseService;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements BaseService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.deleteByObject(object);
    }

    @Override
    public void deletebyId(Long id) {
        super.deleteById(id);
    }
}
