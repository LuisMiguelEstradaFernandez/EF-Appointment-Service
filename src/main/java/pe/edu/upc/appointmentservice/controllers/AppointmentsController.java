package pe.edu.upc.appointmentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.appointmentservice.entities.Appointment;
import pe.edu.upc.appointmentservice.services.AppointmentService;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Appointment> optionalAppointment = appointmentService.findById(id);
            if (optionalAppointment.isPresent()) {
                return new ResponseEntity<Appointment>(optionalAppointment.get(), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/typeOfAppointment/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> fetchByType(@PathVariable("type") String type) {
        try {
            Optional<Appointment> optionalAppointment = appointmentService.findByTypeOfAppointment(type);
            if (optionalAppointment.isPresent()) {
                return ResponseEntity.ok(optionalAppointment.get());
            }
            else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
