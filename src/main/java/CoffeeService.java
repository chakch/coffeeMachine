import java.text.MessageFormat;

/**
 * Created by abdellatif on 16/09/2017.
 */
public class CoffeeService {

    public static final String DRINK_FORMAT = "{0}:{1}:{2}";
    public static final String MESSAGE_MISSING_FORMAT = "M:the missing amount is {0}";

    public static final String EMPTY_STRING = "";

    private IDrink drink;
    private Double inputMoney;

    private String command;

    public CoffeeService(IDrink drink, Double money) {
        this.drink = drink;
        this.inputMoney = money;
    }

    public CoffeeService(IDrink drink) {
        this(drink, null);
    }

    public Boolean verifieCommand() {
        if (drink != null) {
            return true;
        } else {
            return false;
        }
    }

    public void prepareDrinkCommand() {
        if (drink.getSugar() == 0) {
            command = MessageFormat.format(DRINK_FORMAT, drink.getDrinkCode(), EMPTY_STRING, EMPTY_STRING);
        } else {
            command = MessageFormat.format(DRINK_FORMAT, drink.getDrinkCode(), drink.getSugar(), 1);
        }

    }

    public String getCommand() {
        return command;
    }

    public Boolean checkInputMoney() {
        if (Double.compare(inputMoney, drink.getDrinkPrice()) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void getCommandInfo() {
        Double missingAmount = Math.abs(inputMoney - drink.getDrinkPrice());
        if (checkInputMoney()) {
            prepareDrinkCommand();
        } else {
            command = MessageFormat.format(MESSAGE_MISSING_FORMAT, missingAmount);
        }
    }
}
