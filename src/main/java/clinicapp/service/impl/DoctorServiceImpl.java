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
    public void delete(long id) {
        doctorRepository.delete(id);
    }

    @Override
    public Doctor getByLastnameOrFirstname(String firstName,String lastName) {
        return doctorRepository.findByLastnameOrFirstname(firstName,lastName);
    }

    @Override
    public Doctor editDoctor(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
