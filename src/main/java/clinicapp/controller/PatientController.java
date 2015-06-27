package clinicapp.controller;

import clinicapp.Dao.Service.PatientService;
import clinicapp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("patient") Patient patient, BindingResult result) {

        patientService.create(patient);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName() {
        patientService.getByFirstName();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName() {
        patientService.getByLastName();
        return "redirect:/index";
    }


    @RequestMapping(value = "/getByState", method = RequestMethod.GET)
    public String getByState() {
        patientService.getByState();
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("patient", new Patient());
        map.put("patientList", patientService.getAll());

        return "patient";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("patient") Patient patient, BindingResult result) {

        patientService.update(patient);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{patientId}")
    public String delete(@PathVariable("patientId") Integer patientId) {
        patientService.delete(patientId);

        return "redirect:/index";
    }
}
