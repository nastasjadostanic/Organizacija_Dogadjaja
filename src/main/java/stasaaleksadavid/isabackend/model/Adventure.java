package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "Adventures")
public class Adventure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;


    @Column(name = "Address")
    private String address;

    @Column(name = "Description")
    private String description;


    @Column(name = "maxPeople")
    private int maxPeople;


    @Column(name = "RulesOfConduct")
    private String rulesOfConduct;


    @Column(name = "TermsOfReservation")
    private String termsOfReservation;

    @Column(name = "InstructorId")
    private long instructorId;

    @Column(name = "FishingEquipment")
    private String fishingEquipment;

    @Column(name = "AdditionalServices")
    private String additionalServices;

    @Column(name = "Prices")
    private String prices;

    public  Adventure() {}

    public Adventure(String name, String address, String description, int maxPeople, String rulesOfConduct, String termsOfReservation, long instructorId, String fishingEquipment, String additionalServices, String prices) {
        super();
        this.name = name;
        this.address = address;
        this.description = description;
        this.maxPeople = maxPeople;
        this.rulesOfConduct = rulesOfConduct;
        this.termsOfReservation = termsOfReservation;
        this.instructorId = instructorId;
        this.fishingEquipment = fishingEquipment;
        this.additionalServices = additionalServices;
        this.prices = prices;
    }

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRulesOfConduct() {
        return rulesOfConduct;
    }

    public void setRulesOfConduct(String rulesOfConduct) {
        this.rulesOfConduct = rulesOfConduct;
    }


    public String getTermsOfReservation() {
        return termsOfReservation;
    }

    public void setTermsOfReservation(String termsOfReservation) {
        this.termsOfReservation = termsOfReservation;
    }

    public String getFishingEquipment() {
        return fishingEquipment;
    }

    public void setFishingEquipment(String fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
