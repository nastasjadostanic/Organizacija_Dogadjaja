package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Cottage;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {
    List<Cottage> findByOwnerId(Long ownerId );


}
