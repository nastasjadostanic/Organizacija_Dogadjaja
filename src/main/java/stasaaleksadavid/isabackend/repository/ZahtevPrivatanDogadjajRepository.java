package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ZahtevPrivatanDogadjaj;


import java.util.List;

@Repository
public interface ZahtevPrivatanDogadjajRepository extends JpaRepository<ZahtevPrivatanDogadjaj,Long> {
    List<ZahtevPrivatanDogadjaj> findByGostId(long Id);
}