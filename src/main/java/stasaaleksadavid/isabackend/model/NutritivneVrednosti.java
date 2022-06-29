package stasaaleksadavid.isabackend.model;
import javax.persistence.*;


@Entity
@Table(name = "NutritivneVrednosti")
public class NutritivneVrednosti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Energija")
    private float energija;

    @Column(name = "Masti")
    private float masti;

    @Column(name = "ZasiceneMasti")
    private float zasiceneMasti;

    @Column(name = "UH")
    private float UH;

    @Column(name = "Secer")
    private float secer;

    @Column(name = "Vlakna")
    private float vlakna;

    @Column(name = "Proteini")
    private float proteini;

    @Column(name = "So")
    private float so;

    @Column(name = "Hrana_Id")
    private long hranaId;




    public NutritivneVrednosti() {}

    public NutritivneVrednosti(float energija, float masti, float zasiceneMasti, float UH, float secer, float vlakna, float proteini, float so, long hranaId) {
        super();
        this.energija = energija;
        this.masti = masti;
        this.zasiceneMasti = zasiceneMasti;
        this.UH = UH;
        this.secer = secer;
        this.vlakna = vlakna;
        this.proteini = proteini;
        this.so = so;
        this.hranaId = hranaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getEnergija() {
        return energija;
    }

    public void setEnergija(float energija) {
        this.energija = energija;
    }

    public float getMasti() {
        return masti;
    }

    public void setMasti(float masti) {
        this.masti = masti;
    }

    public float getZasiceneMasti() {
        return zasiceneMasti;
    }

    public void setZasiceneMasti(float zasiceneMasti) {
        this.zasiceneMasti = zasiceneMasti;
    }

    public float getUH() {
        return UH;
    }

    public void setUH(float UH) {
        this.UH = UH;
    }

    public float getSecer() {
        return secer;
    }

    public void setSecer(float secer) {
        this.secer = secer;
    }

    public float getVlakna() {
        return vlakna;
    }

    public void setVlakna(float vlakna) {
        this.vlakna = vlakna;
    }

    public float getProteini() {
        return proteini;
    }

    public void setProteini(float proteini) {
        this.proteini = proteini;
    }

    public float getSo() {
        return so;
    }

    public void setSo(float so) {
        this.so = so;
    }

    public long getHranaId() {
        return hranaId;
    }

    public void setHranaId(long hranaId) {
        this.hranaId = hranaId;
    }
}

