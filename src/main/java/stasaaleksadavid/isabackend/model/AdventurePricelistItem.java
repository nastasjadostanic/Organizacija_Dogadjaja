package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "PriceListItems")
public class AdventurePricelistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private long adventureId;

    @Column(name = "")
    private String name;

    @Column(name = "")
    private long price;

    public AdventurePricelistItem() {}

    public AdventurePricelistItem(long adventureId, String name, long price) {
        super();
        this.adventureId = adventureId;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(long adventureId) {
        this.adventureId = adventureId;
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
}
