package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stasaaleksadavid.isabackend.model.CottageQuickAppointment;


import java.util.List;

@Repository
public interface CottageQuickAppointmentRepository extends JpaRepository<CottageQuickAppointment, Long> {
    List<CottageQuickAppointment> findByCottageId(Long cottageId );

}