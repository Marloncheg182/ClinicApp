package clinicapp.Dao.Service;

import clinicapp.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    // Create an object data
    void create(Insurance insurance);

    // get by account
    String getByBankAccount();

    // get all data
    List<Insurance> getAll();

    // update data
    void update(Insurance insurance);

    // delete by id
    void delete(Integer id);
}
