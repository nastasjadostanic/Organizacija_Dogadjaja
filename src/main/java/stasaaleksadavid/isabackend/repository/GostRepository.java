package stasaaleksadavid.isabackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Gost;


@Repository
public interface GostRepository extends JpaRepository<Gost, Long> {

}
