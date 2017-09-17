import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abdellatif on 17/09/2017.
 */
public class CoffeeFactory {


    public static IDrink getDrinkClass(String code, Integer sugar) {
        IDrink drink;
        if ("C".equals(code)) {
            drink= new Coffee(sugar);
        }else
        if ("T".equals(code)) {
            drink= new Tea(sugar);
        }else
        if ("H".equals(code)) {
            drink= new Chocolate(sugar);
        }else
        if ("O".equals(code)) {
            drink =new Orange();
        }else{
            drink=null;
        }
        saveIncomingOrder(drink);
        return drink;
    }

    public static  void saveIncomingOrder(IDrink drink){
        if(drink !=null){
            RepoData.countNewDrink(drink);
        }
    }
}
