package pe.edu.upc.appointmentservice.services;

import pe.edu.upc.appointmentservice.entities.Appointment;

import java.util.Optional;

public interface AppointmentService extends CrudService<Appointment, Long> {
    Optional<Appointment> findByTypeOfAppointment(String typeOfAppointment) throws Exception;
    Optional<Appointment> findByAvailability(String availability) throws Exception;
}
