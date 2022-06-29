package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "client_adventures_complaints")
public class ClientAdventuresComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "adventure_id")
    private long adventureId;

    @Column(name = "message")
    private String message;

    public ClientAdventuresComplaint(){}

    public ClientAdventuresComplaint(long clientId, long adventureId, String message) {
        super();
        this.clientId = clientId;
        this.adventureId = adventureId;
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

    public long getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(long adventureId) {
        this.adventureId = adventureId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
