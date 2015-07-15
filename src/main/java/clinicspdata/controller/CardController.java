package clinicspdata.controller;

import clinicspdata.entity.Card;
import clinicspdata.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Oleg Romanenchuk
 */
@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("card") Card card){

        cardService.create(card);

        return "redirect:/index";

    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }



    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public String getById(Long id){

        cardService.getById(id);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getByLastName", method = RequestMethod.GET)
    public String getByLastName(String lastName){

       cardService.getByLastName(lastName);

        return "redirect:/index";
    }


    @RequestMapping(value = "/getBirthDate", method = RequestMethod.GET)
    public String getByBirthDate(String birthDate){

        cardService.getByBirthDate(birthDate);

        return "redirect:/index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(){

        cardService.getAll();

        return "redirect:/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Card card){

        cardService.update(card);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{cardId}")
    public String delete(Long id){
        cardService.delete(id);

        return "redirect:/index";
    }
}
