package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ShipsAdditionalServices")
public class ShipAdditionalServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private String name;

    @Column(name = "")
    private boolean doesItContain;

    @Column(name = "")
    private long shipId;

    public ShipAdditionalServices() {}

    public ShipAdditionalServices(String name, boolean doesItContain, long shipId) {
        super();
        this.name = name;
        this.doesItContain = doesItContain;
        this.shipId = shipId;
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

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }
}
