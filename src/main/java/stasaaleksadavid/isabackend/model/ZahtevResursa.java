package stasaaleksadavid.isabackend.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ZahteviResursa")
public class ZahtevResursa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DatumZahteva")
    private LocalDate datumZahteva;

    @Column(name = "TipResursa")
    private String tipResursa;

    @Column(name = "ResursID")
    private long resursID ;

    @Column(name = "DogadjajID")
    private long dogadjajID ;

    @Column(name = "GostId")
    private long gostId ;

    public ZahtevResursa() {
    }

    public ZahtevResursa(long id, LocalDate datumZahteva, String tipResursa, long resursID, long dogadjajID, long gostId) {
        this.id = id;
        this.datumZahteva = datumZahteva;
        this.tipResursa = tipResursa;
        this.resursID = resursID;
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

    public String getTipResursa() {
        return tipResursa;
    }

    public void setTipResursa(String tipResursa) {
        this.tipResursa = tipResursa;
    }

    public long getResursID() {
        return resursID;
    }

    public void setResursID(long resursID) {
        this.resursID = resursID;
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
