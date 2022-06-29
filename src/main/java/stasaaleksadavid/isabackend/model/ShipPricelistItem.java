package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ShipsPricelistItems")
public class ShipPricelistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private String name;

    @Column(name = "")
    private long price;

    @Column(name = "")
    private long shipId;

    public ShipPricelistItem() {}

    public ShipPricelistItem(String name, long price, long shipId) {
        super();
        this.name = name;
        this.price = price;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }
}
