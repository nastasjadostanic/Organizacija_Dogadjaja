package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.MainAdmin;


@Repository
public interface MainAdminRepository extends JpaRepository<MainAdmin, Long> {
}
