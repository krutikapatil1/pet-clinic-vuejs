package krutika.springframework.petclinic.services.map.springdatajpa;

import krutika.springframework.petclinic.model.Specialty;
import krutika.springframework.petclinic.repositories.SpecialtyRepository;
import krutika.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
@Service
@Profile("springdatajpa")
public class SpecialtySDJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
