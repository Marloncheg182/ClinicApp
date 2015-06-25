package clinicapp.service.impl;


import clinicapp.dbrepository.InsuranceRepository;
import clinicapp.entity.Insurance;
import clinicapp.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;


    @Override
    public Insurance addInsurance(Insurance insurance) {
        Insurance saveInsurance = insuranceRepository.saveAndFlush(insurance);
        return saveInsurance;
    }

    @Override
    public Insurance getByBankAccount(String bankaccount) {
        return insuranceRepository.findByBankAccount(bankaccount);
    }

    @Override
    public Insurance editInsurance(Insurance insurance) {
        return insuranceRepository.saveAndFlush(insurance);
    }

    @Override
    public void delete(long id) {
        insuranceRepository.delete(id);
    }
}
