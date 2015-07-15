package clinicspdata.services;

import clinicapp.entity.Doctor;
import clinicapp.entity.doctors.DoctorPosition;
import clinicapp.entity.doctors.Rating;


import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Doctor Serivce
 */
public interface DoctorService {

    Doctor create(Doctor doctor);

    Doctor getByFirstName(String firstName);

    Doctor getByLastName(String lastName);

    Doctor getByAge(Integer age);

    Doctor getByPosition(DoctorPosition position);

    Doctor getByRating(Rating rating);

    List<Doctor> getAll();

    Doctor update(Doctor doctor);

    void delete(Long id);


}
