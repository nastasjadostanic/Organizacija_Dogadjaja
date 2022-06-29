package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "LjudskiResursi")

public class LjudskiResursi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "Cena")
    private float cena;

    @Column(name = "Vrsta")
    private String vrsta;

    @Column(name = "BrojLjudi")
    private int brojLjudi;

    @Column(name = "OblastDelovanja")
    private String oblastDelovanja;

    @Column(name = "BrojTelefona")
    private String brojTelefona;

    @Column(name = "DogadjajID")
    private long dogadjajID;

    public LjudskiResursi() {
    }

    public LjudskiResursi(long id, String naziv, float cena, String vrsta, int brojLjudi, String oblastDelovanja, String brojTelefona, long dogadjajID) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.vrsta = vrsta;
        this.brojLjudi = brojLjudi;
        this.oblastDelovanja = oblastDelovanja;
        this.brojTelefona = brojTelefona;
        this.dogadjajID = dogadjajID;;
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

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getBrojLjudi() {
        return brojLjudi;
    }

    public void setBrojLjudi(int brojLjudi) {
        this.brojLjudi = brojLjudi;
    }

    public String getOblastDelovanja() {
        return oblastDelovanja;
    }

    public void setOblastDelovanja(String oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public long getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(long dogadjajID) {
        this.dogadjajID = dogadjajID;
    }
}

