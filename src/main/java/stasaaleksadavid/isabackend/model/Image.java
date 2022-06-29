package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.sql.Clob;

@Entity
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Type")
    private String type;

    @Column(name = "ID_Of_Type")
    private long idOfType;

    @Column(name = "Image1")
    private String image1;

    @Column(name = "Image2")
    private String image2;

    @Column(name = "Image3")
    private String image3;

    @Column(name = "Image4")
    private String image4;

    @Column(name = "Image5")
    private String image5;

    public Image() {
    }

    public Image(String type, long idOfType, String image1, String image2, String image3, String image4, String image5) {
        super();
        this.type = type;
        this.idOfType = idOfType;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
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

    public long getIdOfType() {
        return idOfType;
    }

    public void setIdOfType(long idOfType) {
        this.idOfType = idOfType;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
}

