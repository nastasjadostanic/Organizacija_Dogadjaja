package stasaaleksadavid.isabackend.model;


import javax.persistence.*;

@Entity
@Table(name = "FishingEquipment")
public class FishingEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    public FishingEquipment() {
    }

    public FishingEquipment(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
