package clinicapp.service.impl;

import clinicapp.dbrepository.DoctorRepository;
import clinicapp.entity.Doctor;
import clinicapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        Doctor saveDoctor = doctorRepository.saveAndFlush(doctor);
        return saveDoctor;
    }

    @Override
    public Doctor getByFirstName(String firstName) {
        return doctorRepository.findByFirstName(firstName);
    }

    @Override
    public Doctor getByLastName(String lastName) {
        return doctorRepository.findByLastName(lastName);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getByPosition(String position) {
        return doctorRepository.findByPosition(position);
    }

    @Override
    public Doctor getByRating(String rating) {
        return doctorRepository.findByRating(rating);
    }

    @Override
    public Doctor editDoctor(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void delete(long id) {
        doctorRepository.delete(id);
    }
}
