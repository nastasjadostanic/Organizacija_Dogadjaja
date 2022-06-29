package stasaaleksadavid.isabackend.model;
import net.bytebuddy.implementation.bind.annotation.Super;
import javax.persistence.*;

@Entity
@Table(name = "Sale")

public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "Cena")
    private float cena;

    @Column(name = "BrojMesta")
    private int brojMesta;

    @Column(name = "Tip")
    private String Tip;

    @Column(name = "VrsteDogadjaja")
    private String VrstaDogadjaja;

    public Sala() {
    }

    public Sala(long id, String naziv, float cena, int brojMesta, String tip, String vrstaDogadjaja) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.brojMesta = brojMesta;
        Tip = tip;
        VrstaDogadjaja = vrstaDogadjaja;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public String getVrstaDogadjaja() {
        return VrstaDogadjaja;
    }

    public void setVrstaDogadjaja(String vrstaDogadjaja) {
        VrstaDogadjaja = vrstaDogadjaja;
    }
}
