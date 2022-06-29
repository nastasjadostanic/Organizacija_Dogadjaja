package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Cottage_Additional_Services")
public class CottageAdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CottageId")
    private long cottageId;

    @Column(name = "WIFI_Price")
    private double wifiPrice ;

    @Column(name = "WIFI_Information")
    private String wifiInformation;

    @Column(name = "Parking_Price")
    private double parkingPrice ;

    @Column(name = "Parking_Information")
    private String parkingInformation ;

    @Column(name = "Pet_Bed_Price")
    private double petBedPrice ;

    @Column(name = "Pet_Bed_Information")
    private String petBedInformation;

    @Column(name = "Air_Conditioner_Price")
    private double airConditionerPrice;

    @Column(name = "Air_Conditioner_Information")
    private String airConditionerInformation;



    public CottageAdditionalServices() {
    }


    public CottageAdditionalServices(long cottageId, double wifiPrice, String wifiInformation, double parkingPrice, String parkingInformation, double petBedPrice, String petBedInformation, double airConditionerPrice, String airConditionerInformation) {
        super();
        this.cottageId = cottageId;
        this.wifiPrice = wifiPrice;
        this.wifiInformation = wifiInformation;
        this.parkingPrice = parkingPrice;
        this.parkingInformation = parkingInformation;
        this.petBedPrice = petBedPrice;
        this.petBedInformation = petBedInformation;
        this.airConditionerPrice = airConditionerPrice;
        this.airConditionerInformation = airConditionerInformation;
    }

    public long getCottageId() {
        return cottageId;
    }

    public void setCottageId(long cottageId) {
        this.cottageId = cottageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWifiPrice() {
        return wifiPrice;
    }

    public void setWifiPrice(double wifiPrice) {
        this.wifiPrice = wifiPrice;
    }

    public String getWifiInformation() {
        return wifiInformation;
    }

    public void setWifiInformation(String wifiInformation) {
        this.wifiInformation = wifiInformation;
    }

    public double getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(double parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public String getParkingInformation() {
        return parkingInformation;
    }

    public void setParkingInformation(String parkingInformation) {
        this.parkingInformation = parkingInformation;
    }

    public double getPetBedPrice() {
        return petBedPrice;
    }

    public void setPetBedPrice(double petBedPrice) {
        this.petBedPrice = petBedPrice;
    }

    public String getPetBedInformation() {
        return petBedInformation;
    }

    public void setPetBedInformation(String petBedInformation) {
        this.petBedInformation = petBedInformation;
    }

    public double getAirConditionerPrice() {
        return airConditionerPrice;
    }

    public void setAirConditionerPrice(double airConditionerPrice) {
        this.airConditionerPrice = airConditionerPrice;
    }

    public String getAirConditionerInformation() {
        return airConditionerInformation;
    }

    public void setAirConditionerInformation(String airConditionerInformation) {
        this.airConditionerInformation = airConditionerInformation;
    }
}
