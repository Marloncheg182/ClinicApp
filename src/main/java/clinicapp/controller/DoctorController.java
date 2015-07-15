package clinicapp.controller;

import clinicapp.Dao.Service.DoctorService;
import clinicspdata.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {

        doctorService.create(doctor);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName() {
        doctorService.getByFirstName();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName() {
        doctorService.getByLastName();
        return "redirect:/index";
    }


    @RequestMapping(value = "/getByPosition", method = RequestMethod.GET)
    public String getByPosition() {
        doctorService.getByPosition();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByRating", method = RequestMethod.GET)
    public String getByRating() {
        doctorService.getByRating();
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("doctor", new Doctor());
        map.put("doctorList", doctorService.getAll());

        return "doctor";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {

        doctorService.update(doctor);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{doctorId}")
    public String delete(@PathVariable("doctorId") Integer doctorId) {
        doctorService.delete(doctorId);

        return "redirect:/index";
    }
}
