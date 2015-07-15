package clinicspdata.util;

import clinicspdata.entity.Patient;
import clinicspdata.entity.patients.PatientState;

/**
 * @author Oleg Romanenchuk
 */
public class PatientUtil {
    public static Patient create() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setFirstName("Johny");
        patient.setLastName("Depp");
        patient.setAge(45);
        patient.setState(PatientState.EASY);
        patient.setPhoneNumber("......");
        return patient;
    }
}
