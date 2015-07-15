package clinicspdata.util;

import clinicspdata.entity.Clinic;

/**
 * @author Oleg Romanenchuk
 */
public class ClinicUtil {
    public static Clinic create() {
        Clinic clinic = new Clinic();
        clinic.setId(1);
        clinic.setName("Pringston-Plaintsboro");
        return clinic;
    }
}
