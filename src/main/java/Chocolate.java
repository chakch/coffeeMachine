/**
 * Created by abdellatif on 17/09/2017.
 */
public class Chocolate extends Drink {
    public static final String CHOCOLATE_CODE = "H";

    public static final Double CHOCOLATE_VALUE = 0.5;

    public Chocolate(Integer sugar) {
        this.code = CHOCOLATE_CODE;
        this.price = CHOCOLATE_VALUE;
        this.sugar = sugar;
    }
}
