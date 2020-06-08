package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Specialty;
import krutika.springframework.petclinic.model.Vet;
import krutika.springframework.petclinic.services.BaseService;
import krutika.springframework.petclinic.services.SpecialtyService;
import krutika.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/4/2020, Thu
 **/
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
