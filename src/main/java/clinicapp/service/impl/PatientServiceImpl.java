package clinicapp.service.impl;

import clinicapp.dbrepository.PatientRepository;
import clinicapp.entity.Patient;
import clinicapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        Patient savePatient = patientRepository.saveAndFlush(patient);
        return savePatient;
    }

    @Override
    public Patient getByFirstName(String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    @Override
    public Patient getByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public Patient getByState(String state) {
        return patientRepository.findByState(state);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient editPatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public void delete(long id) {
        patientRepository.delete(id);
    }
}
