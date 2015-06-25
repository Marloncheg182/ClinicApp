package clinicapp.service.impl;

import clinicapp.dbrepository.ClinicRepository;
import clinicapp.entity.Clinic;
import clinicapp.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;


    @Override
    public Clinic addClinic(Clinic clinic) {
        Clinic savedClinic = clinicRepository.saveAndFlush(clinic);
        return savedClinic;
    }

    @Override
    public void delete(long id) {
        clinicRepository.delete(id);
    }

    @Override
    public Clinic getByName(String name) {
        return clinicRepository.findByName(name);
    }

    @Override
    public Clinic editClinic(Clinic clinic) {
        return clinicRepository.saveAndFlush(clinic);
    }

    @Override
    public List<Clinic> getAll() {
        return clinicRepository.findAll();
    }

}
