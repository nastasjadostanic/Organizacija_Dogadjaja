package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ClientPenalties;

@Repository
public interface ClientPenaltiesRepository extends JpaRepository<ClientPenalties,Long> {
}
