package clinicspdata.controller;

import clinicspdata.entity.Insurance;
import clinicspdata.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */
@Controller
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("insurance")Insurance insurance ){

        insuranceService.create(insurance);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }



    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id){

        insuranceService.getById(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        insuranceService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Insurance insurance){

        insuranceService.update(insurance);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{insuranceId}")
    public String delete(Long id){
        insuranceService.delete(id);

        return "redirect:/index";
    }


}



