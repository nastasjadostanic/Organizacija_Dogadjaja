package stasaaleksadavid.isabackend.model;

import javax.persistence.*;


@Entity
@Table(name = "OstaliResursi")

public class OstaliResursi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "Cena")
    private float cena;

    @Column(name = "Tip")
    private String tip;

    @Column(name = "Boja")
    private String boja;

    @Column(name = "Stil")
    private String stil;

    @Column(name = "Kolicina")
    private int kolicina;

    @Column(name = "DogadjajID")
    private long dogadjajID;

    public OstaliResursi() {
    }

    public OstaliResursi(long id, String naziv, float cena, String tip, String boja, String stil, int kolicina, long dogadjajID) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.boja = boja;
        this.stil = stil;
        this.kolicina = kolicina;
        this.dogadjajID = dogadjajID;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public long getDogadjajID() {
        return dogadjajID;
    }

    public void setDogadjajID(long dogadjajID) {
        this.dogadjajID = dogadjajID;
    }
}

