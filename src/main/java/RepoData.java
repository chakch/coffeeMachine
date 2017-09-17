import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by abdellatif on 17/09/2017.
 */
public class RepoData {
    private static Integer numberOfDrink = 0;
    private static Map<String,Double> drinkCountMap = new LinkedHashMap<String, Double>();
    public static  String outPutFormat = "{0}: {1}$ ";

    public static void countNewDrink(IDrink drink){
        numberOfDrink++;
        if (drinkCountMap.containsKey(drink.getDrinkCode())){
            Double previousValue = drinkCountMap.get(drink.getDrinkCode());
            BigDecimal newValue =BigDecimal.valueOf(previousValue).add(BigDecimal.valueOf(drink.getDrinkPrice()));
            drinkCountMap.put(drink.getDrinkCode(),newValue.doubleValue());
        }else{
            drinkCountMap.put(drink.getDrinkCode(),drink.getDrinkPrice());
        }
    }
    public static Integer  getNumberOfDrink(){
        return numberOfDrink;
    }

    public static Map<String,Double> getDrinkCountMap(){
        return drinkCountMap;
    }

    public static void  resetCounting(){
        numberOfDrink = 0;
        drinkCountMap = new HashMap<String, Double>();
    }

    public static String getSummary() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry entry:drinkCountMap.entrySet()){
            if ("C".equals(entry.getKey())) {
                sb.append(MessageFormat.format(outPutFormat,"Coffee",entry.getValue()));
            }else if ("T".equals(entry.getKey())) {
                sb.append(MessageFormat.format(outPutFormat,"Tea",entry.getValue()));
            }else if ("H".equals(entry.getKey())) {
                sb.append(MessageFormat.format(outPutFormat,"Chocolate",entry.getValue()));
            }else if ("O".equals(entry.getKey())) {
                sb.append(MessageFormat.format(outPutFormat,"Orange",entry.getValue()));
            }
        }
    return sb.toString();
    }

}
