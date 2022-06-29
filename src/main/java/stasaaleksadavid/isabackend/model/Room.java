package stasaaleksadavid.isabackend.model;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int numberOfBeds;

    @Column
    private String number;

    @Column
    private String description;

    @Column
    private Long cottageId;

    public Room(int numberOfBeds, String number, String description, Long cottageId) {
        super();
        this.numberOfBeds = numberOfBeds;
        this.number = number;
        this.description = description;
        this.cottageId = cottageId;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCottageId() {
        return cottageId;
    }

    public void setCottageId(Long cottageId) {
        this.cottageId = cottageId;
    }
}