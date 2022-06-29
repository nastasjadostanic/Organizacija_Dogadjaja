package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Ship_Subscription")
public class ShipSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ShipId")
    private long shipId;

    @Column(name = "Email")
    private String email;

    public ShipSubscription(long shipId,String email) {
        super();
        this.shipId = shipId;
        this.email = email;
    }

    public ShipSubscription() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
