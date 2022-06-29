package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "client_points")
public class ClientPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(name = "points")
    private int points;

    @Column(name = "user_category")
    private LoyaltyCategory userCategory;

    public ClientPoints() {}

    public ClientPoints( int points, LoyaltyCategory userCategory) {
        super();

        this.points = points;
        this.userCategory = userCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LoyaltyCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(LoyaltyCategory userCategory) {
        this.userCategory = userCategory;
    }
}
