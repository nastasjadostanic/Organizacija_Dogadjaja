package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Porudzbenica;

import java.util.List;

@Repository
public interface PorudzbenicaRepository extends JpaRepository<Porudzbenica, Long> {
    List<Porudzbenica> findByGostId(Long gostId);


}


