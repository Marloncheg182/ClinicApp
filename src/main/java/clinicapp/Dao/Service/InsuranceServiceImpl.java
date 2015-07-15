package clinicapp.Dao.Service;

import clinicapp.Dao.InsuranceDAO;
import clinicspdata.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceDAO insuranceDAO;


    @Transactional
    public void create(Insurance insurance) {
        insuranceDAO.create(insurance);
    }

    @Transactional
    public String getByBankAccount() {
        return insuranceDAO.getByBankAccount();
    }

    @Transactional
    public List<Insurance> getAll() {
        return insuranceDAO.getAll();
    }

    @Transactional
    public void update(Insurance insurance) {
        insuranceDAO.update(insurance);
    }

    @Transactional
    public void delete(Integer id) {
        insuranceDAO.delete(id);
    }
}
