package clinicspdata.controller;

import clinicapp.entity.Nurse;
import clinicapp.entity.nurses.NursePosition;
import clinicspdata.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("nurse")Nurse nurse){

        nurseService.create(nurse);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByAge", method = RequestMethod.GET)
    public String getByAge(Integer age){

        nurseService.getByAge(age);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName(String firstName){

        nurseService.getByLastName(firstName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName(String lastName){

        nurseService.getByLastName(lastName);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByPosition", method = RequestMethod.GET)
    public String getByPosition(NursePosition position){

        nurseService.getByPosition(position);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        nurseService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Nurse nurse){

        nurseService.update(nurse);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{nurseId}")
    public String delete(Long id){
        nurseService.delete(id);

        return "redirect:/index";
    }
}
