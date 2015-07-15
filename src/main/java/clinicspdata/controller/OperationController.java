package clinicspdata.controller;

import clinicapp.entity.Operation;
import clinicspdata.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("operation")Operation operation){

        operationService.create(operation);

        return "redirect:/index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id){

        operationService.getById(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate(String date){

        operationService.getByDate(date);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    public String getByType(String type){

        operationService.getByType(type);

        return "redirect:/index";

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        operationService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Operation operation){

        operationService.update(operation);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{operationId}")
    public String delete(Long id){
        operationService.delete(id);

        return "redirect:/index";
    }
}
