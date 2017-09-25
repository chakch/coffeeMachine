/**
 * Created by abdellatif on 17/09/2017.
 */
public class Tea extends Drink {
    public static final String TEA_CODE = "T";
    public static final Double TEA_PRICE = 0.4;

    public static final String TEA_MESSAGE ="TEA is missing";


    public Tea(Integer sugar) {
        this.code = TEA_CODE;
        this.price = TEA_PRICE;
        this.sugar = sugar;
        this.isHot = false;
    }
    public String getErrorMessage(){
        return TEA_MESSAGE;
    }
}
