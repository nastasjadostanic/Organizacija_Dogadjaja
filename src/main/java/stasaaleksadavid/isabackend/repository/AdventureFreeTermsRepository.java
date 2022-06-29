package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureFreeTerms;

@Repository
public interface AdventureFreeTermsRepository extends JpaRepository<AdventureFreeTerms,Long> {
}
