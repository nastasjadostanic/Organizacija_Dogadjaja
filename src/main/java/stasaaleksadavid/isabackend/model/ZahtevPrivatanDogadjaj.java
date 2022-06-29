package stasaaleksadavid.isabackend.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ZahteviPrivatnihDogadjaja")
public class ZahtevPrivatanDogadjaj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DatumOdrzavanja")
    private LocalDate datumOdrzavanja;

    @Column(name = "VremeOdrzavanja")
    private String vremeOdrzavanja;

    @Column(name = "Trajanje")
    private String trajanje ;

    @Column(name = "Vrsta")
    private String vrsta;

    @Column(name = "BrojMesta")
    private int brojMesta;

    @Column(name = "Organizator")
    private String organizator;

    @Column(name = "LjudskiResursId")
    private long ljudskiResursId;

    @Column(name = "OstaliResursId")
    private long ostaliResursId;

    @Column(name = "GostId")
    private long gostId ;

    public ZahtevPrivatanDogadjaj() {
    }

    public ZahtevPrivatanDogadjaj(long id, LocalDate datumOdrzavanja, String vremeOdrzavanja, String trajanje, String vrsta, int brojMesta, String organizator, long ljudskiResursId, long ostaliResursId, long gostID) {
        this.id = id;
        this.datumOdrzavanja = datumOdrzavanja;
        this.vremeOdrzavanja = vremeOdrzavanja;
        this.trajanje = trajanje;
        this.vrsta = vrsta;
        this.brojMesta = brojMesta;
        this.organizator = organizator;
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

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public String getOrganizator() {
        return organizator;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
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
