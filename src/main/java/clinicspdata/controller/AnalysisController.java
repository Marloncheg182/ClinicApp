package clinicspdata.controller;

import clinicapp.entity.Analysis;
import clinicspdata.services.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Oleg Romanenchuk
 */

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("analysis")Analysis analysis, BindingResult result){

        analysisService.create(analysis);

        return "redirect:/index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id){

        analysisService.getById(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate(String date){

        analysisService.getByDate(date);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        analysisService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Analysis analysis){

        analysisService.update(analysis);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{analysisId}")
    public String delete(Long id){
        analysisService.delete(id);

        return "redirect:/index";
    }
}
