package stasaaleksadavid.isabackend.model;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ShipsBusyTerms")
public class ShipBusyTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private LocalDateTime startTime;

    @Column(name="")
    private LocalDateTime endTime;

    @Column(name = "")
    private long shipId;

    public ShipBusyTerms(){}

    public ShipBusyTerms(LocalDateTime startTime, LocalDateTime endTime, long shipId) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
        this.shipId = shipId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }
}
