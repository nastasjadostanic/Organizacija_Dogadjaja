package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Dogadjaj;

import java.util.List;

@Repository
public interface DogadjajRepository extends JpaRepository<Dogadjaj,Long> {
    List<Dogadjaj> findByGostId(long Id);

}
