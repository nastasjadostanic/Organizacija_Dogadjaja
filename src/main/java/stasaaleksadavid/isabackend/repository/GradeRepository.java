package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Grade;

import java.util.List;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Long> {
     List<Grade> findByTypeAndTypeId(String type, long typeId);
}
