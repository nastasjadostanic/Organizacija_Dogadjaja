package stasaaleksadavid.isabackend.model;
import javax.persistence.*;


@Entity
@Table(name = "Cottages")
public class Cottage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Description")
    private String description;

    @Column(name = "Rating")
    private double rating;

    @Column(name = "Number_Of_Rooms")
    private int numberOfRooms;

    @Column(name = "Rules")
    private String rules;

    @Column(name = "Owner_Id")
    private long ownerId;

    @Column(name = "Photos", length = 64)
    private String photos;


    public Cottage() {}

    public Cottage(String name, String address, String description, double rating, int numberOfRooms, String rules, long ownerId, String photos) {
        super();
        this.name = name;
        this.address = address;
        this.description = description;
        this.rating = rating;
        this.numberOfRooms = numberOfRooms;
        this.rules = rules;
        this.ownerId = ownerId;
        this.photos = photos;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription (String description) {
        this.description =description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating (double rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

}
