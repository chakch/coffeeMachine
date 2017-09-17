/**
 * Created by abdellatif on 17/09/2017.
 */
public abstract class Drink implements IDrink {

    public static final String HOT_CODE = "h";
    public static final String NORMAL_CODE = "";
    protected String code;
    protected Double price;
    protected Integer sugar;
    protected Boolean isHot;


    public String getDrinkCode() {
        return code;
    }

    public Double getDrinkPrice() {
        return price;
    }

    public Integer getSugar() {
        return sugar;
    }

    public String informClient() {
        if (isHot) {
            return HOT_CODE;
        } else {
            return NORMAL_CODE;
        }
    }
}
