package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "AdventuresAdditionalEquipment")
public class AdventureAdditionalEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private String name;

    @Column(name = "")
    private boolean doesItContain;

    @Column(name = "")
    private long adventureId;

    public AdventureAdditionalEquipment() {}

    public AdventureAdditionalEquipment(String name, boolean doesItContain, long adventureId) {
        super();
        this.name = name;
        this.doesItContain = doesItContain;
        this.adventureId = adventureId;
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

    public boolean isDoesItContain() {
        return doesItContain;
    }

    public void setDoesItContain(boolean doesItContain) {
        this.doesItContain = doesItContain;
    }

    public long getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(long adventureId) {
        this.adventureId = adventureId;
    }
}
