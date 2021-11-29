package pe.edu.upc.appointmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.appointmentservice.entities.Appointment;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByTypeOfAppointment(String typeOfAppointment);
    Optional<Appointment> findByAvailability(String availability);
}
