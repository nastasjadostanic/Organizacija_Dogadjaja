package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.GradeRequest;

@Repository
public interface GradeRequestRepository extends JpaRepository<GradeRequest, Long> {
}
