package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.*;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findByOwnerId(Long ownerId );
}
