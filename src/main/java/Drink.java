/**
 * Created by abdellatif on 17/09/2017.
 */
public abstract class Drink implements IDrink {
    protected String code;
    protected Double price;
    protected Integer sugar;


    public String getDrinkCode() {
        return code;
    }

    public Double getDrinkPrice() {
        return price;
    }

    public Integer getSugar() {
        return sugar;
    }
}
