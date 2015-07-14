package clinicspdata.util;

import clinicapp.entity.Card;

/**
 * @author Oleg Romanenchuk
 */
public class CardUtil {
    public static Card create() {
        Card card = new Card();
        card.setId(1);
        card.setFirstName("Johny");
        card.setLastName("Depp");
        card.setBirthDate(".....");
        card.setDiagnosis("Appendix");
        card.setSymptoms("High temperature, pain inside under stomach");
        card.setAdditionalNotes("ardor, shock");


        return card;
    }
}
