package clinicspdata.util;

import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;

/**
 * @author Oleg Romanenchuk
 */
public class DoctorUtil {
    public static Doctor create() {
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setFirstName("Gregory");
        doctor.setLastName("House");
        doctor.setAge(45);
        doctor.setPosition(DoctorPosition.PHYSICIAN);
        doctor.setPhoneNumber("......");
        doctor.setRating(Rating.HEAD);
        return doctor;
    }
}
