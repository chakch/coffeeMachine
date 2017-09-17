/**
 * Created by abdellatif on 17/09/2017.
 */
public class CoffeeFactory {


    public static IDrink getDrinkClass(String code, Integer sugar) {
        if ("C".equals(code)) {
            return new Coffee(sugar);
        }
        if ("T".equals(code)) {
            return new Tea(sugar);
        }
        if ("H".equals(code)) {
            return new Chocolate(sugar);
        }
        if ("O".equals(code)) {
            return new Orange();
        }
        return null;
    }
}
