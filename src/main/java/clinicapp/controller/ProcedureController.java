package clinicapp.controller;

import clinicapp.Dao.Service.ProcedureService;
import clinicspdata.entity.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("procedure") Procedure procedure, BindingResult result) {

        procedureService.create(procedure);

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("procedure", new Procedure());
        map.put("procedureList", procedureService.getAll());

        return "procedure";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById() {
        procedureService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate() {
        procedureService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("procedure") Procedure procedure, BindingResult result) {

        procedureService.update(procedure);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{procedureId}")
    public String delete(@PathVariable("procedureId") Integer procedureId) {
        procedureService.delete(procedureId);

        return "redirect:/index";
    }
}

