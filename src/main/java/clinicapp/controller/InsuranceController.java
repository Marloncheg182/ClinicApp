package clinicapp.controller;

import clinicapp.Dao.Service.InsuranceService;
import clinicapp.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("procedure") Insurance insurance, BindingResult result) {

        insuranceService.create(insurance);

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("insurance", new Insurance());
        map.put("insuranceList", insuranceService.getAll());

        return "insurance";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByAccount", method = RequestMethod.GET)
    public String getByBankAccount() {
        insuranceService.getByBankAccount();
        return "redirect:/index";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("insurance") Insurance insurance, BindingResult result) {

        insuranceService.update(insurance);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{insuranceId}")
    public String delete(@PathVariable("insuranceId") Integer insuranceId) {
        insuranceService.delete(insuranceId);

        return "redirect:/index";
    }
}

