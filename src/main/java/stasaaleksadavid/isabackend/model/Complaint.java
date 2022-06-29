package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "OnWhat")
    private String onWhat;

    @Column(name = "ComplaintMessage")
    private String complaintMessage;

    @Column(name = "EmailOfComplaintRecipient")
    private String emailOfComplaintRecipient;

    @Column(name = "EmailOfComplaintSender")
    private String emailOfComplaintSender;

    public Complaint() {
    }
    public Complaint( String onWhat,String complaintMessage, String emailOfComplaintRecipient, String emailOfComplaintSender) {
        super();
        this.onWhat=onWhat;
        this.complaintMessage=complaintMessage;
        this.emailOfComplaintRecipient=emailOfComplaintRecipient;
        this.emailOfComplaintSender=emailOfComplaintSender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOnWhat() {
        return onWhat;
    }

    public void setOnWhat(String onWhat) {
        this.onWhat = onWhat;
    }

    public String getComplaintMessage() {
        return complaintMessage;
    }

    public void setComplaintMessage(String complaintMessage) {
        this.complaintMessage = complaintMessage;
    }

    public String getEmailOfComplaintRecipient() {
        return emailOfComplaintRecipient;
    }

    public void setEmailOfComplaintRecipient(String emailOfComplaintRecipient) {
        this.emailOfComplaintRecipient = emailOfComplaintRecipient;
    }

    public String getEmailOfComplaintSender() {
        return emailOfComplaintSender;
    }

    public void setEmailOfComplaintSender(String emailOfComplaintSender) {
        this.emailOfComplaintSender = emailOfComplaintSender;
    }
}
