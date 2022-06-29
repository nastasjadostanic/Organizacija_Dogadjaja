package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Hrana;

import java.util.List;

@Repository
public interface HranaRepository extends JpaRepository<Hrana, Long> {
    List<Hrana> findByCena(Float cena);
    List<Hrana> findByTipHrane(String tipHrane);
    List<Hrana> findByOcena(Float ocena);

}
