/**
 * Created by abdellatif on 17/09/2017.
 */
public class Coffee extends Drink {

    public static final String COFFRE_CODE = "C";
    public static final Double COFFEE_PRICE = 0.6;

    public static final String COFFE_MESSAGE ="COFFE is missing";


    public Coffee(Integer sugar) {
        this.code = COFFRE_CODE;
        this.price = COFFEE_PRICE;
        this.sugar = sugar;
        this.isHot = false;
    }

    public Coffee(Integer sugar, Boolean isHot) {
        this(sugar);
        this.isHot = isHot;
    }

    public String getErrorMessage(){
        return COFFE_MESSAGE;
    }

}
