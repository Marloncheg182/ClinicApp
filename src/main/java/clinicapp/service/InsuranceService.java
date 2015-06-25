package clinicapp.service;


import clinicapp.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    // Create table
    Insurance addInsurance(Insurance insurance);

    // Read by accoint
    Insurance getByBankAccount(String bankaccount);

    // Update
    Insurance editInsurance(Insurance insurance);

    // Delete by id
    void delete(long id);
}
