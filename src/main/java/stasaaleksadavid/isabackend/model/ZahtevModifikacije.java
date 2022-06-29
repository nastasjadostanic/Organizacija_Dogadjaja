package stasaaleksadavid.isabackend.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ZahteviModifikacije")
public class ZahtevModifikacije {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DatumZahteva")
    private LocalDate datumZahteva;

    @Column(name = "OpisZahteva")
    private String opisZahteva;

    @Column(name = "DogadjajID")
    private long dogadjajID ;

    @Column(name = "GostID")
    private long gostId ;

    public ZahtevModifikacije() {
    }

    public ZahtevModifikacije(long id, LocalDate datumZahteva, String opisZahteva, long dogadjajID, long gostId) {
        this.id = id;
        this.datumZahteva = datumZahteva;
        this.opisZahteva = opisZahteva;
        this.dogadjajID = dogadjajID;
        this.gostId = gostId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatumZahteva() {
        return datumZahteva;
    }

    public void setDatumZahteva(LocalDate datumZahteva) {
        this.datumZahteva = datumZahteva;
    }

    public String getOpisZahteva() {
        return opisZahteva;
    }

    public void setOpisZahteva(String opisZahteva) {
        this.opisZahteva = opisZahteva;
    }

    public long getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(long dogadjajID) {
        this.dogadjajID = dogadjajID;
    }

    public long getGostId() {
        return gostId;
    }

    public void setGostId(long gostId) {
        this.gostId = gostId;
    }
}
