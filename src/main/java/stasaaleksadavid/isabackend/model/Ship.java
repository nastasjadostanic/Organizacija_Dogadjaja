package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Owner_Id")
    private long ownerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Column(name = "Length")
    private float length;

    @Column(name = "Number_Of_Engines")
    private int numberOfEngines;

    @Column(name = "HP")
    private float hp;

    @Column(name = "Top_Speed")
    private float topSpeed;

    @Column(name = "Navigation")
    private String navigation;

    @Column(name = "Address")
    private String address;

    @Column(name = "Description")
    private String description;

    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "Rules")
    private String rules;

    @Column(name = "Fishing_Equipment")
    private String fishingEquipment;

    //@Column(name = "Additional_Services")
   // private String name;

   // @Column(name = "uslovi otkazivanja")
   // private String name;

    public Ship() {
    }

    public Ship(long ownerId, String name, String type, float length, int numberOfEngines, float hp, float topSpeed, String navigation, String address, String description, int capacity, String rules, String fishingEquipment) {
       super();
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
        this.length = length;
        this.numberOfEngines = numberOfEngines;
        this.hp = hp;
        this.topSpeed = topSpeed;
        this.navigation = navigation;
        this.address = address;
        this.description = description;
        this.capacity = capacity;
        this.rules = rules;
        this.fishingEquipment = fishingEquipment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getFishingEquipment() {
        return fishingEquipment;
    }

    public void setFishingEquipment(String fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }
}

