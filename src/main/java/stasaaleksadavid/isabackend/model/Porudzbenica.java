package stasaaleksadavid.isabackend.model;
import javax.persistence.*;


@Entity
@Table(name = "Porudzbenica")
public class Porudzbenica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "GostId")
    private long gostId;

    @Column(name = "Komentar")
    private String komentar;

    public Porudzbenica() {
    }

    public Porudzbenica(long gostId, String komentar) {
        super();
        this.gostId = gostId;
        this.komentar = komentar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGostId() {
        return gostId;
    }

    public void setGostId(long gostId) {
        this.gostId = gostId;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}

