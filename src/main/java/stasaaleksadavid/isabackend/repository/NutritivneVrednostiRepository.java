package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.NutritivneVrednosti;

import java.util.List;

@Repository
public interface NutritivneVrednostiRepository extends JpaRepository<NutritivneVrednosti, Long> {
    NutritivneVrednosti findByHranaId(Long hranaId);

}

