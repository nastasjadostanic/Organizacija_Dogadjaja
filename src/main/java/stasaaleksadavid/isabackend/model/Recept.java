package stasaaleksadavid.isabackend.model;
import javax.persistence.*;


@Entity
@Table(name = "Recept")
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "Recept")
    private String recept;

    @Column(name = "Hrana_Id")
    private long hranaId;


    public Recept() {}

    public Recept( String recept, long hranaId) {
        super();

        this.recept = recept;
        this.hranaId = hranaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

    public long getHranaId() {
        return hranaId;
    }

    public void setHranaId(long hranaId) {
        this.hranaId = hranaId;
    }
}

