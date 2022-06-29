package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.LjudskiResursi;

import java.util.List;

@Repository
public interface LjudskiResursiRepository extends JpaRepository<LjudskiResursi,Long> {
   List<LjudskiResursi> findByDogadjajID(Long dogadjajID);
}