package clinicspdata.controller;

import clinicapp.entity.Clinic;
import clinicspdata.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 */

@Controller
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("clinic") Clinic clinic){

        clinicService.create(clinic);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }



    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id){

        clinicService.getById(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public String getByName(String name){

        clinicService.getByName(name);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        clinicService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Clinic clinic){

        clinicService.update(clinic);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{clinicId}")
    public String delete(Long id){
        clinicService.delete(id);

        return "redirect:/index";
    }

}
