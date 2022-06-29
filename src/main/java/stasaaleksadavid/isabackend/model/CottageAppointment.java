package stasaaleksadavid.isabackend.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cottage_Appointments")
public class CottageAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Cottage_ID")
    private long cottageId;

    @Column(name = "Client_ID")
    private long clientId;

    @Column(name = "Starting_Date")
    private LocalDate startingDate;

    @Column(name = "Ending_Date")
    private LocalDate endingDate;

    @Column(name = "Numer_Of_People")
    private int numberOfPeople ;

    @Column(name = "Additional_Services")
    private String additionalServices;

    @Column(name = "Price")
    private double price;

    public CottageAppointment() {
    }

    public CottageAppointment(long cottageId, long clientId, LocalDate startingDate, LocalDate endingDate, int numberOfPeople, String additionalServices, double price) {
        super();
        this.cottageId = cottageId;
        this.clientId = clientId;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.numberOfPeople = numberOfPeople;
        this.additionalServices = additionalServices;
        this.price = price;
    }

    public long getCottageId() {
        return cottageId;
    }

    public void setCottageId(long cottageId) {
        this.cottageId = cottageId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
