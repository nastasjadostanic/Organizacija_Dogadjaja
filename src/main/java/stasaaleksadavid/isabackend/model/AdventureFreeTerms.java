package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AdventuresFreeTerms")
public class AdventureFreeTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private LocalDateTime startTime;

    @Column(name ="")
    private LocalDateTime endTime;

    @Column(name="")
    private long adventureId;

    public AdventureFreeTerms() {}

    public AdventureFreeTerms(LocalDateTime startTime, LocalDateTime endTime, long adventureId) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
        this.adventureId = adventureId;
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

    public long getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(long adventureId) {
        this.adventureId = adventureId;
    }
}
