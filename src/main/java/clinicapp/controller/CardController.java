package clinicapp.controller;

import clinicapp.Dao.Service.CardService;
import clinicspdata.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("card")Card card, BindingResult result){

        cardService.create(card);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getByFirstName", method = RequestMethod.GET)
    public String getByFirstName() {
        cardService.getByFirstName();
        return "redirect:/index";
    }

    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName(){
        cardService.getByLastName();
        return "redirect:/index";
    }
    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById() {
        cardService.getById();
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getAll(Map<String, Object> map){

        map.put("card", new Card());
        map.put("cardList", cardService.getAll());

        return "card";
    }

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("card")Card card, BindingResult result){

        cardService.update(card);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{cardId}")
    public String delete(@PathVariable("cardId") Integer cardId) {
        cardService.delete(cardId);

        return "redirect:/index";
    }
}
