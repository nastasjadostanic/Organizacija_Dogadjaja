package stasaaleksadavid.isabackend.model;


import javax.persistence.*;

@Entity
@Table(name = "Income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IncomeFromReservations")
    private Float incomeFromReservations;

    @Column(name = "PercentageOfReservations")
    private Float percentageOfReservations;

    public Income() {
    }

    public Income(Float incomeFromReservations, Float percentageOfReservations) {
        this.incomeFromReservations = incomeFromReservations;
        this.percentageOfReservations = percentageOfReservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getIncomeFromReservations() {
        return incomeFromReservations;
    }

    public void setIncomeFromReservations(Float incomeFromReservations) {
        this.incomeFromReservations = incomeFromReservations;
    }

    public Float getPercentageOfReservations() {
        return percentageOfReservations;
    }

    public void setPercentageOfReservations(Float percentageOfReservations) {
        this.percentageOfReservations = percentageOfReservations;
    }
}

