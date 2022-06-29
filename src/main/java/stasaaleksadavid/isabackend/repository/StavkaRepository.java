package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Stavka;

import java.util.List;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {
    List<Stavka> findByHranaId(Long hranaId);
    List<Stavka> findByPorudzbenicaId(Long porudzbenicaId);


}

