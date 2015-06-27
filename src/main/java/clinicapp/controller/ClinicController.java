package clinicapp.controller;

import clinicapp.Dao.Service.ClinicService;
import clinicapp.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("clinic", new Clinic());
        map.put("clinicList", clinicService.getAll());

        return "clinic";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("clinic") Clinic clinic, BindingResult result) {

        clinicService.create(clinic);

        return "redirect:/index";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getByName() {
        clinicService.getName();
        return "redirect:/index";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("clinic") Clinic clinic, BindingResult result) {

        clinicService.update(clinic);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{clinicId}")
    public String delete(@PathVariable("clinicId") Integer clinicId) {
        clinicService.delete(clinicId);

        return "redirect:/index";
    }
}
