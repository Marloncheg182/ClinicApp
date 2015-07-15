package clinicspdata.controller;

import clinicspdata.entity.Procedure;
import clinicspdata.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("procedure") Procedure procedure) {

        procedureService.create(procedure);

        return "redirect:/index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id) {

        procedureService.getById(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate(String date) {

        procedureService.getByDate(date);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll() {

        procedureService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Procedure procedure) {

        procedureService.update(procedure);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{procedureId}")
    public String delete(Long id) {
        procedureService.delete(id);

        return "redirect:/index";
    }
}
