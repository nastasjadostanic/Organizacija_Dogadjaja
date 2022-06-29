package stasaaleksadavid.isabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "client_ship_complaints")
public class ClientShipComplaint{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "ship_id")
    private long shipId;

    @Column(name = "message")
    private String message;

    public ClientShipComplaint(){}

    public ClientShipComplaint(long clientId, long shipId, String message) {
        super();
        this.clientId = clientId;
        this.shipId = shipId;
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

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
