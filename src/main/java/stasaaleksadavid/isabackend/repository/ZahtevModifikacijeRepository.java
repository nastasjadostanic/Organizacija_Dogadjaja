package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ZahtevModifikacije;


import java.util.List;

@Repository
public interface ZahtevModifikacijeRepository extends JpaRepository<ZahtevModifikacije,Long> {
    List<ZahtevModifikacije> findByGostId(long Id);
}