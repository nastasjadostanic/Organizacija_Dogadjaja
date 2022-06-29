package stasaaleksadavid.isabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stasaaleksadavid.isabackend.exception.ResourceNotFoundException;
import stasaaleksadavid.isabackend.model.CottageAppointment;
import stasaaleksadavid.isabackend.model.CottageFreeAppointment;
import stasaaleksadavid.isabackend.repository.CottageAppointmentRepository;
import stasaaleksadavid.isabackend.repository.CottageFreeAppointmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CottageAppointmentController {

    @Autowired
    private CottageAppointmentRepository cottageAppointmentRepository;

    @Autowired
    private CottageFreeAppointmentRepository cottageFreeAppointmentRepository;

    //get all

    @GetMapping("/cottageappointments")
    public List<CottageAppointment> getAllCottageAppointments() {
        return cottageAppointmentRepository.findAll();
    }

    //create
    @PostMapping("/cottageappointments/{type}")
    public CottageAppointment createCottageAppointment(@PathVariable String type,@RequestBody CottageAppointment cottageAppointment) {
        if (type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {

            List<CottageFreeAppointment> cottageFreeAppointments = cottageFreeAppointmentRepository.findByCottageId(cottageAppointment.getCottageId());

            for (CottageFreeAppointment c : cottageFreeAppointments) {
                if (cottageAppointment.getStartingDate().isAfter(c.getStartingDate()) && cottageAppointment.getEndingDate().isBefore(c.getEndingDate())) {

                    CottageFreeAppointment freeAppointment_1 = new CottageFreeAppointment(c.getCottageId(), c.getStartingDate(), cottageAppointment.getStartingDate(), c.getNumberOfPeople(), c.getAdditionalServices(), c.getPrice());
                    CottageFreeAppointment freeAppointment_2 = new CottageFreeAppointment(c.getCottageId(), cottageAppointment.getEndingDate(), c.getEndingDate(), c.getNumberOfPeople(), c.getAdditionalServices(), c.getPrice());
                    CottageAppointment newCottageAppointment = new CottageAppointment(cottageAppointment.getCottageId(), cottageAppointment.getClientId(), cottageAppointment.getStartingDate(), cottageAppointment.getEndingDate(), cottageAppointment.getNumberOfPeople(), cottageAppointment.getAdditionalServices(), cottageAppointment.getPrice());

                    cottageFreeAppointmentRepository.deleteById(c.getId());
                    cottageFreeAppointmentRepository.save(freeAppointment_1);
                    cottageFreeAppointmentRepository.save(freeAppointment_2);

                    return cottageAppointmentRepository.save(newCottageAppointment);
                } else if (cottageAppointment.getStartingDate().isAfter(c.getStartingDate()) && cottageAppointment.getEndingDate().isAfter(c.getEndingDate())) {
                    CottageFreeAppointment freeAppointment_1 = new CottageFreeAppointment(c.getCottageId(), c.getStartingDate(), cottageAppointment.getStartingDate(), c.getNumberOfPeople(), c.getAdditionalServices(), c.getPrice());
                    CottageAppointment newCottageAppointment = new CottageAppointment(cottageAppointment.getCottageId(), cottageAppointment.getClientId(), cottageAppointment.getStartingDate(), c.getEndingDate(), cottageAppointment.getNumberOfPeople(), c.getAdditionalServices(), c.getPrice());
                    cottageFreeAppointmentRepository.deleteById(c.getId());
                    cottageFreeAppointmentRepository.save(freeAppointment_1);

                    return cottageAppointmentRepository.save(newCottageAppointment);
                } else if (cottageAppointment.getStartingDate().isBefore(c.getStartingDate()) && cottageAppointment.getEndingDate().isBefore(c.getEndingDate())) {
                    CottageFreeAppointment freeAppointment_1 = new CottageFreeAppointment(c.getCottageId(), cottageAppointment.getEndingDate(), c.getEndingDate(), c.getNumberOfPeople(), c.getAdditionalServices(), c.getPrice());
                    CottageAppointment newCottageAppointment = new CottageAppointment(cottageAppointment.getCottageId(), cottageAppointment.getClientId(), c.getStartingDate(), cottageAppointment.getEndingDate(), cottageAppointment.getNumberOfPeople(), cottageAppointment.getAdditionalServices(), cottageAppointment.getPrice());

                    cottageFreeAppointmentRepository.deleteById(c.getId());
                    cottageFreeAppointmentRepository.save(freeAppointment_1);

                    return cottageAppointmentRepository.save(newCottageAppointment);
                } else if (cottageAppointment.getStartingDate().isBefore(c.getStartingDate()) && cottageAppointment.getEndingDate().isAfter(c.getEndingDate())) {

                    return null;
                }
            }

            return cottageAppointmentRepository.save(cottageAppointment);
        }
        else return null;
    }

    //get by id
    @GetMapping("/cottageappointments/{id}")
    public ResponseEntity<CottageAppointment> getCottageAppointmentById(@PathVariable Long id) {
        CottageAppointment cottageAppointment = cottageAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAppointment does not exist with id:" + id));
        return ResponseEntity.ok(cottageAppointment);
    }

    //update
    @PutMapping("/cottageappointments/{id}")
    public ResponseEntity<CottageAppointment> updateCottageAppointment(@PathVariable Long id, @RequestBody CottageAppointment cottageAppointmentDetails) {
        CottageAppointment cottageAppointment = cottageAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAppointment does not exist with id:" + id));

        cottageAppointment.setClientId(cottageAppointmentDetails.getClientId());
        cottageAppointment.setCottageId(cottageAppointmentDetails.getCottageId());
        cottageAppointment.setStartingDate(cottageAppointmentDetails.getStartingDate());
        cottageAppointment.setEndingDate(cottageAppointmentDetails.getEndingDate());
        cottageAppointment.setNumberOfPeople(cottageAppointmentDetails.getNumberOfPeople());
        cottageAppointment.setAdditionalServices(cottageAppointmentDetails.getAdditionalServices());
        cottageAppointment.setPrice(cottageAppointmentDetails.getPrice());


        CottageAppointment updatedCottageAppointment = cottageAppointmentRepository.save(cottageAppointment);
        return ResponseEntity.ok(updatedCottageAppointment);
    }


    //delete
    @DeleteMapping("/cottageappointments/{id}")
    public Map<String, Boolean> deleteCottageAppointment(@PathVariable Long id) {

        CottageAppointment cottageAppointment = cottageAppointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CottageAppointment does not exist with id:" + id));

        cottageAppointmentRepository.delete(cottageAppointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

    //get by cottage id
    @GetMapping("/cottageappointments/cottage/{type}/{cottageid}")
    public List<CottageAppointment> getAppointmentByCottageId(@PathVariable String type,@PathVariable Long cottageid) {
        if (type.equals("admin") || type.equals("cottage_owner") || type.equals("main_admin")) {
            return cottageAppointmentRepository.findByCottageId(cottageid);
        }
        else return null;
    }


}

