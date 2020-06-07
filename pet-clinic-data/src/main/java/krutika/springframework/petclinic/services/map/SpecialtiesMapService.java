package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Specialty;
import krutika.springframework.petclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/6/2020, Sat
 **/
@Service
public class SpecialtiesMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Specialty object) {
        super.deleteByObject(object);
    }

    @Override
    public void deletebyId(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
