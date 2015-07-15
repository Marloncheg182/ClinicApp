package clinicspdata.controller;

import clinicspdata.entity.Doctor;
import clinicspdata.entity.doctors.DoctorPosition;
import clinicspdata.entity.doctors.Rating;
import clinicspdata.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("doctor") Doctor doctor){

        doctorService.create(doctor);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByAge", method = RequestMethod.GET)
    public String getByAge(Integer age){

        doctorService.getByAge(age);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName(String firstName){

        doctorService.getByLastName(firstName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName(String lastName){

        doctorService.getByLastName(lastName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByPosition", method = RequestMethod.GET)
    public String getByPosition(DoctorPosition position){

        doctorService.getByPosition(position);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByRating", method = RequestMethod.GET)
    public String getByRating(Rating rating){

      doctorService.getByRating(rating);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        doctorService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Doctor doctor){

        doctorService.update(doctor);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{doctorId}")
    public String delete(Long id){
        doctorService.delete(id);

        return "redirect:/index";
    }

}


