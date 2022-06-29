package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name="ClientReviews")
public class ClientReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IdOfReceiver")
    private String idOfReceiver;

    @Column(name = "IdOfSender")
    private String idOfSender;

    @Column(name = "EmailOfReceiver")
    private String emailOfReceiver;

    @Column(name = "EmailOfSender")
    private String emailOfSender;

    @Column(name = "ReviewMessage")
    private String reviewMessage;

    public ClientReview() {
    }

    public ClientReview(String idOfReceiver, String idOfSender, String emailOfReceiver, String emailOfSender, String reviewMessage) {
        this.idOfReceiver = idOfReceiver;
        this.idOfSender = idOfSender;
        this.emailOfReceiver = emailOfReceiver;
        this.emailOfSender = emailOfSender;
        this.reviewMessage = reviewMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdOfReceiver() {
        return idOfReceiver;
    }

    public void setIdOfReceiver(String idOfReceiver) {
        this.idOfReceiver = idOfReceiver;
    }

    public String getIdOfSender() {
        return idOfSender;
    }

    public void setIdOfSender(String idOfSender) {
        this.idOfSender = idOfSender;
    }

    public String getEmailOfReceiver() {
        return emailOfReceiver;
    }

    public void setEmailOfReceiver(String emailOfReceiver) {
        this.emailOfReceiver = emailOfReceiver;
    }

    public String getEmailOfSender() {
        return emailOfSender;
    }

    public void setEmailOfSender(String emailOfSender) {
        this.emailOfSender = emailOfSender;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }
}
