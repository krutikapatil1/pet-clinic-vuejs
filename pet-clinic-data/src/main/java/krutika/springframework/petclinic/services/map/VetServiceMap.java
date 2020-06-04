package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.BaseService;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
public class VetServiceMap extends AbstractMapService<Vet, Long> implements BaseService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.deleteByObject(object);
    }

    @Override
    public void deletebyId(Long id) {
        super.deleteById(id);
    }
}
