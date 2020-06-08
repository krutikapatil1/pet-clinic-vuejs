package krutika.springframework.petclinic.services.map;

import krutika.springframework.petclinic.model.Visit;
import krutika.springframework.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author : Krutika Patil
 * @since : 6/8/2020, Mon
 **/
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getOwner() == null ||
        object.getPet().getId() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit object");
        }
        else {
            return super.save(object);
        }
    }

    @Override
    public void delete(Visit object) {
        super.deleteByObject(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
