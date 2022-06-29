package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.LjudskiResursi;
import stasaaleksadavid.isabackend.model.OstaliResursi;
import java.util.List;
@Repository
public interface OstaliResursiRepository extends JpaRepository<OstaliResursi,Long> {
    List<OstaliResursi> findByDogadjajID(Long dogadjajID);
}