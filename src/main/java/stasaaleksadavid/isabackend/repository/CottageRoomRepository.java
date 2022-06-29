package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.*;

@Repository
public interface CottageRoomRepository extends JpaRepository<CottageRoom,Long> {
}
