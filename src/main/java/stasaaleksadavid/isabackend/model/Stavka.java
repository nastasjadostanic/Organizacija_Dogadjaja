package stasaaleksadavid.isabackend.model;
import javax.persistence.*;


@Entity
@Table(name = "Stavka")
public class Stavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Kolicina")
    private int kolicina;

    @Column(name = "PorudzbenicaId")
    private long porudzbenicaId;

    @Column(name = "Hrana_Id")
    private long hranaId;


    public Stavka() {
    }

    public Stavka( int kolicina, long porudzbenicaId, long hranaId) {
        super();

        this.kolicina = kolicina;
        this.porudzbenicaId = porudzbenicaId;
        this.hranaId = hranaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public long getPorudzbenicaId() {
        return porudzbenicaId;
    }

    public void setPorudzbenicaId(long porudzbenicaId) {
        this.porudzbenicaId = porudzbenicaId;
    }

    public long getHranaId() {
        return hranaId;
    }

    public void setHranaId(long hranaId) {
        this.hranaId = hranaId;
    }
}