package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "client_cottage_complaints")
public class ClientCottageComplaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "cottage_id")
    private long cottageId;

    @Column(name = "message")
    private String message;

    public ClientCottageComplaints(){}

    public ClientCottageComplaints(long clientId, long cottageId, String message) {
        super();
        this.clientId = clientId;
        this.cottageId = cottageId;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCottageId() {
        return cottageId;
    }

    public void setCottageId(long cottageId) {
        this.cottageId = cottageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
