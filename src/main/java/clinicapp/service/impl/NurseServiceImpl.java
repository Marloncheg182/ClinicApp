package clinicapp.service.impl;


import clinicapp.dbrepository.NurseRepository;
import clinicapp.entity.Nurse;
import clinicapp.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public Nurse addNurse(Nurse nurse) {
        Nurse saveNurse = nurseRepository.saveAndFlush(nurse);
        return saveNurse;
    }

    @Override
    public Nurse getByFirstName(String firstName) {
        return nurseRepository.findByFirstName(firstName);
    }

    @Override
    public Nurse getByLastName(String lastName) {
        return nurseRepository.findByLastName(lastName);
    }

    @Override
    public Nurse getByPosition(String position) {
        return nurseRepository.findByPosition(position);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse editNurse(Nurse nurse) {
        return nurseRepository.saveAndFlush(nurse);
    }

    @Override
    public void delete(long id) {
        nurseRepository.delete(id);
    }
}
