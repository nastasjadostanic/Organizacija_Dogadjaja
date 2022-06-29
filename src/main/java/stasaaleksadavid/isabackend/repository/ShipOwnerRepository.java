package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipOwner;

@Repository
public interface ShipOwnerRepository extends JpaRepository<ShipOwner, Long> {
    ShipOwner findByEmailAndPassword(String email, String password);
}
