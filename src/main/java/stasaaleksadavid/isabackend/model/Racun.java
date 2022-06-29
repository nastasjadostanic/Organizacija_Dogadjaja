package stasaaleksadavid.isabackend.model;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Racun")
public class Racun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PorudzbenicaId")
    private long porudzbenicaId;

    @Column(name = "Datum")
    private LocalDate datum;

    public Racun() {
    }

    public Racun(long porudzbenicaId, LocalDate datum) {
        super();
        this.porudzbenicaId = porudzbenicaId;
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPorudzbenicaId() {
        return porudzbenicaId;
    }

    public void setPorudzbenicaId(long porudzbenicaId) {
        this.porudzbenicaId = porudzbenicaId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}

