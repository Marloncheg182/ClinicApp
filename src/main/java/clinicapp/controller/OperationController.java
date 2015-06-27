package clinicapp.controller;

import clinicapp.Dao.Service.OperationService;
import clinicapp.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("operation") Operation operation, BindingResult result) {

        operationService.create(operation);

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("operation", new Operation());
        map.put("operationList", operationService.getAll());

        return "operation";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById() {
        operationService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate() {
        operationService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("operation") Operation operation, BindingResult result) {

        operationService.update(operation);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{operationId}")
    public String delete(@PathVariable("operationId") Integer operationId) {
        operationService.delete(operationId);

        return "redirect:/index";
    }
}


