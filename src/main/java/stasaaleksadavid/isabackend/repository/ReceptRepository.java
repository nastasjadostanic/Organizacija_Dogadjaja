package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Recept;

import java.util.List;

@Repository
public interface ReceptRepository extends JpaRepository<Recept, Long> {
    Recept findByHranaId(Long hranaId);

}
