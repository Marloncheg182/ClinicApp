package clinicapp.controller;

import clinicapp.Dao.Service.NurseService;
import clinicspdata.entity.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("nurse") Nurse nurse, BindingResult result) {

        nurseService.create(nurse);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName() {
        nurseService.getByFirstName();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName() {
        nurseService.getByLastName();
        return "redirect:/index";
    }


    @RequestMapping(value = "/getByPosition", method = RequestMethod.GET)
    public String getByPosition() {
        nurseService.getByPosition();
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("nurse", new Nurse());
        map.put("nurseList", nurseService.getAll());

        return "nurse";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("nurse") Nurse nurse, BindingResult result) {

        nurseService.update(nurse);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{nurseId}")
    public String delete(@PathVariable("nurseId") Integer nurseId) {
        nurseService.delete(nurseId);

        return "redirect:/index";
    }
}


