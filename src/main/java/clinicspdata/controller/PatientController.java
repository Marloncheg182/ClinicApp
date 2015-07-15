package clinicspdata.controller;

import clinicapp.entity.Patient;
import clinicapp.entity.patients.PatientState;
import clinicspdata.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("patient")Patient patient){

        patientService.create(patient);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByAge", method = RequestMethod.GET)
    public String getByAge(Integer age){

        patientService.getByAge(age);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName(String firstName){

        patientService.getByLastName(firstName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName(String lastName){

        patientService.getByLastName(lastName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByState", method = RequestMethod.GET)
    public String getByState(PatientState state){

        patientService.getByState(state);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        patientService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Patient patient){

        patientService.update(patient);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{patientId}")
    public String delete(Long id){
        patientService.delete(id);

        return "redirect:/index";
    }
}
