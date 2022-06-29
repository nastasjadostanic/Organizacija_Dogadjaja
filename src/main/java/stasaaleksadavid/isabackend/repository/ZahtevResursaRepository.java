package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Dogadjaj;
import stasaaleksadavid.isabackend.model.ZahtevResursa;

import java.util.List;

@Repository
public interface ZahtevResursaRepository extends JpaRepository<ZahtevResursa,Long> {
    List<ZahtevResursa> findByGostId(long Id);
}