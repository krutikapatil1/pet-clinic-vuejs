package krutika.springframework.petclinic.model;

import java.io.Serializable;

/**
 * @author : Krutika Patil
 * @since : 6/2/2020, Tue
 **/
public class BaseEntity implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
