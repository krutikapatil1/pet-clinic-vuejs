package krutika.springframework.petclinic.model;

/**
 * @author : Krutika Patil
 * @since : 6/6/2020, Sat
 **/
public class Specialty extends BaseEntity{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
