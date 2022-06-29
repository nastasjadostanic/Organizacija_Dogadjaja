package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.CottageOwner;



@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Long> {
    CottageOwner findByEmailAndPassword(String email, String password);
}
