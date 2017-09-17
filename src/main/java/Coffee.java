/**
 * Created by abdellatif on 17/09/2017.
 */
public class Coffee extends Drink {

    public static final String COFFRE_CODE = "C";
    public static final Double COFFEE_PRICE = 0.6;

    public Coffee(Integer sugar) {
        this.code = COFFRE_CODE;
        this.price = COFFEE_PRICE;
        this.sugar = sugar;

    }
}
