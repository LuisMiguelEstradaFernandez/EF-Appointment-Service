package pe.edu.upc.appointmentservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_of_appointment", length = 40, nullable = false)
    private String typeOfAppointment;

    @Column(nullable = false)
    private String availability;

    @Column(length = 100, nullable = false)
    private String results;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(length = 1, nullable = false)
    private String status;
}
