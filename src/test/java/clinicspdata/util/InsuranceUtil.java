package clinicspdata.util;

import clinicspdata.entity.Insurance;

/**
 * @author Oleg Romanenchuk
 */
public class InsuranceUtil {
    public static Insurance create() {
        Insurance insurance = new Insurance();
        insurance.setId(1);
        insurance.setBankAccount(92364585);
        return insurance;
    }
}
