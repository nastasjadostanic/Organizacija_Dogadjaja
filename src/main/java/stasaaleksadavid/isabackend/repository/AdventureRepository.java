package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Adventure;


import java.util.List;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure,Long> {

    List<Adventure> findByInstructorId(Long instructorId);
    List<Adventure> findByName(String name);
}
