package stasaaleksadavid.isabackend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Hrana")
public class Hrana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "TipHrane")
    private String tipHrane;

    @Column(name = "Cena")
    private Float cena;

    @Column(name = "Ocena")
    private Float ocena;



    public Hrana() {    }

    public Hrana(String naziv, String tipHrane, Float cena, Float ocena) {
        super();
        this.naziv = naziv;
        this.tipHrane = tipHrane;
        this.cena = cena;
        this.ocena = ocena;
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

    public String getTipHrane() {
        return tipHrane;
    }

    public void setTipHrane(String tipHrane) {
        this.tipHrane = tipHrane;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }
}