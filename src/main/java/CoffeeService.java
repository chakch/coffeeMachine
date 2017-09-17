import java.text.MessageFormat;

/**
 * Created by abdellatif on 16/09/2017.
 */
public class CoffeeService {

    public static final String DRINK_FORMAT = "{0}:{1}:{2}";
    public static final String COFFRE_CODE = "C";
    public static final String EMPTY_STRING = "";
    public static final String TEA_CODE = "T";
    public static final String CHOCOLATE_CODE = "H";

    private String drink;
    private Integer sugar;

    private String command;


    public CoffeeService(String drink, Integer sugar) {
        this.drink = drink;
        this.sugar = sugar;
    }

    public Boolean verifieCommand() {
        if (COFFRE_CODE.equals(drink) || TEA_CODE.equals(drink) || CHOCOLATE_CODE.equals(drink)) {
            return true;
        } else {
            return false;
        }
    }

    public void prepareCommand() {
        if (sugar == 0) {
            command = MessageFormat.format(DRINK_FORMAT, drink, EMPTY_STRING, EMPTY_STRING);
        } else {
            command = MessageFormat.format(DRINK_FORMAT, drink, sugar, 1);

        }

    }

    public String getCommand() {
        return command;
    }
}
