package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ClientShipComplaint;

@Repository
public interface ClientShipComplaintRepository extends JpaRepository<ClientShipComplaint,Long> {
}
