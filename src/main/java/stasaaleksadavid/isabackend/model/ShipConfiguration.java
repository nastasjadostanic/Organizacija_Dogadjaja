package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Ships_Configuration")
public class ShipConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "")
    private String type;

    @Column(name = "")
    private int lenght;

    @Column(name = "")
    private int numberOfEngines;

    @Column(name = "")
    private  int enginesPower;

    @Column(name = "")
    private int maxSpeed;

    @Column(name = "")
    private int capacity;

    @Column(name = "")
    private long shipId;

    public ShipConfiguration() {}

    public ShipConfiguration(String type, int lenght, int numberOfEngines, int enginesPower, int maxSpeed, int capacity, long shipId) {
        super();
        this.type = type;
        this.lenght = lenght;
        this.numberOfEngines = numberOfEngines;
        this.enginesPower = enginesPower;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
        this.shipId = shipId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public int getEnginesPower() {
        return enginesPower;
    }

    public void setEnginesPower(int enginesPower) {
        this.enginesPower = enginesPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }
}
