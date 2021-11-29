package pe.edu.upc.appointmentservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.appointmentservice.entities.Appointment;
import pe.edu.upc.appointmentservice.repositories.AppointmentRepository;
import pe.edu.upc.appointmentservice.services.AppointmentService;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    @Override
    public Appointment save(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> findAll() throws Exception {
        return appointmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Appointment> findById(Long aLong) throws Exception {
        return appointmentRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Appointment update(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        appointmentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Appointment> findByTypeOfAppointment(String typeOfAppointment) throws Exception {
        return appointmentRepository.findByTypeOfAppointment(typeOfAppointment);
    }

    @Override
    public Optional<Appointment> findByAvailability(String availability) throws Exception {
        return appointmentRepository.findByAvailability(availability);
    }

}
