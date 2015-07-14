package clinicspdata.services;

import clinicapp.entity.Patient;
import clinicapp.entity.patients.PatientState;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Patient Service
 */
public interface PatientService {

    Patient create(Patient patient);

    Patient getByFirstName(String firstName);

    Patient getByLastName(String lastName);

    Patient getByAge(Integer age);

    Patient getByState(PatientState state);

    List<Patient> getAll();

    Patient update(Patient patient);

    void delete(Long id);


}
