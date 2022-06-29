package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Racun;

import java.util.List;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Long> {
    Racun findByPorudzbenicaId(Long porudzbenicaId);


}
