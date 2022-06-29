package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Cottage_Subscription")
public class CottageSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CottageId")
    private long cottageId;

    @Column(name = "Email")
    private String email;

    public CottageSubscription(long cottageId, String email) {
        super();
        this.cottageId = cottageId;
        this.email = email;
    }

    public CottageSubscription() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCottageId() {
        return cottageId;
    }

    public void setCottageId(long cottageId) {
        this.cottageId = cottageId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
