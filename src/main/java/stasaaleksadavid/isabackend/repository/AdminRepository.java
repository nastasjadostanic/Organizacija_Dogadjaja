package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
