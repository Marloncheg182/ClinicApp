package clinicapp.service;

import clinicapp.entity.Doctor;

import java.util.List;

/**
 * Created by Dell on 6/25/2015.
 */
public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    void delete(long id);

    Doctor getByLastName(String lastName);

    Doctor editDoctor(Doctor doctor);

    List<Doctor> getAll();
}
