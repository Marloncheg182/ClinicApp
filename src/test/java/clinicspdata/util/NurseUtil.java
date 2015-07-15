package clinicspdata.util;

import clinicspdata.entity.Nurse;
import clinicspdata.entity.nurses.NursePosition;

/**
 * @author Oleg Romanenchuk
 */
public class NurseUtil {
    public static Nurse create() {
        Nurse nurse = new Nurse();
        nurse.setId(1);
        nurse.setFirstName("Mary");
        nurse.setLastName("Swanson");
        nurse.setAge(26);
        nurse.setPosition(NursePosition.CNS);
        nurse.setPhoneNumber("......");
        return nurse;
    }
}
