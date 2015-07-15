package clinicapp.controller;

import clinicapp.Dao.Service.AnalysisService;
import clinicspdata.entity.Analysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("analysis") Analysis analysis, BindingResult result) {

        analysisService.create(analysis);

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map) {

        map.put("analysis", new Analysis());
        map.put("analysisList", analysisService.getAll());

        return "analysis";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById() {
        analysisService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getDate", method = RequestMethod.GET)
    public String getByDate() {
        analysisService.getById();
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("analysis") Analysis analysis, BindingResult result) {

        analysisService.update(analysis);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{analysisId}")
    public String delete(@PathVariable("analysisId") Integer analysisId) {
        analysisService.delete(analysisId);

        return "redirect:/index";
    }
}
