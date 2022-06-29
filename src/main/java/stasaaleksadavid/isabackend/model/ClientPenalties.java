package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_penalties")
public class ClientPenalties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "penalty_date")
    private LocalDateTime penaltyDate;

    public ClientPenalties(){}

    public ClientPenalties(long id, long userId, LocalDateTime penaltyDate) {
        super();
        this.userId = userId;
        this.penaltyDate = penaltyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPenaltyDate() {
        return penaltyDate;
    }

    public void setPenaltyDate(LocalDateTime penaltyDate) {
        this.penaltyDate = penaltyDate;
    }
}
