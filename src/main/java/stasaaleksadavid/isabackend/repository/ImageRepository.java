package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Image;


import java.util.List;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByTypeAndIdOfType(String type, long idOfType);


}
