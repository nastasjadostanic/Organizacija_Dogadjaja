package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Adventure_Subscription")
public class AdventureSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "AdventureId")
    private long adventureId;

    @Column(name = "Email")
    private String email;

    public AdventureSubscription(long adventureId, String email) {
        super();
        this.adventureId = adventureId;
        this.email = email;
    }

    public AdventureSubscription() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
