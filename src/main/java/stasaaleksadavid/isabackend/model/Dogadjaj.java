package stasaaleksadavid.isabackend.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Dogadjaji")
public class Dogadjaj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UkupnaCena")
    private String ukupnaCena;

    @Column(name = "DatumNaplate")
    private LocalDate datumNaplate;

    @Column(name = "DatumOdrzavanja")
    private LocalDate datumOdrzavanja;

    @Column(name = "VremeOdrzavanja")
    private String vremeOdrzavanja;

    @Column(name = "Trajanje")
    private int trajanje;

    @Column(name = "Tip")
    private String tip;

    @Column(name = "SalaID")
    private long salaID;

    @Column(name = "ModifikacijaSale")
    private String modifikacijaSale;

    @Column(name = "LjudskiResursId")
    private long ljudskiResursId;

    @Column(name = "OstaliResursId")
    private long ostaliResursId;

    @Column(name = "GostId")
    private long gostId;

    public Dogadjaj() {
    }

    public Dogadjaj(long id, String ukupnaCena, LocalDate datumNaplate, LocalDate datumOdrzavanja, String vremeOdrzavanja, int trajanje, String tip, long salaID, String modifikacijaSale, long ljudskiResursId, long ostaliResursId, long gostId) {
        this.id = id;
        this.ukupnaCena = ukupnaCena;
        this.datumNaplate = datumNaplate;
        this.datumOdrzavanja = datumOdrzavanja;
        this.vremeOdrzavanja = vremeOdrzavanja;
        this.trajanje = trajanje;
        this.tip = tip;
        this.salaID = salaID;
        this.modifikacijaSale = modifikacijaSale;
        this.ljudskiResursId = ljudskiResursId;
        this.ostaliResursId = ostaliResursId;
        this.gostId = gostId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(String ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public LocalDate getDatumNaplate() {
        return datumNaplate;
    }

    public void setDatumNaplate(LocalDate datumNaplate) {
        this.datumNaplate = datumNaplate;
    }

    public LocalDate getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public String getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(String vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getSalaID() {
        return salaID;
    }

    public void setSalaID(long salaID) {
        this.salaID = salaID;
    }

    public String getModifikacijaSale() {
        return modifikacijaSale;
    }

    public void setModifikacijaSale(String modifikacijaSale) {
        this.modifikacijaSale = modifikacijaSale;
    }

    public long getLjudskiResursId() {
        return ljudskiResursId;
    }

    public void setLjudskiResursId(long ljudskiResursId) {
        this.ljudskiResursId = ljudskiResursId;
    }

    public long getOstaliResursId() {
        return ostaliResursId;
    }

    public void setOstaliResursId(long ostaliResursId) {
        this.ostaliResursId = ostaliResursId;
    }

    public long getGostId() {
        return gostId;
    }

    public void setGostId(long gostId) {
        this.gostId = gostId;
    }
}


