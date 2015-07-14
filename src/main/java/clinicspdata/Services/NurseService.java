package clinicspdata.services;

import clinicapp.entity.Nurse;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Nurse Service
 */
public interface NurseService {

    Nurse create(Nurse nurse);

    Nurse getByFirstName(String firstName);

    Nurse getByLastName(String lastName);

    Nurse getByAge(Integer age);

    Nurse getByPosition(String position);

    List<Nurse> getAll();

    Nurse update(Nurse nurse);

    void delete(Long id);
}
