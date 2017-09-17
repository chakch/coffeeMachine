/**
 * Created by abdellatif on 17/09/2017.
 */
public class Orange extends Drink {
    public static final String ORANGE_CODE = "O";

    public static final Double ORANGE_VALUE = 0.6;

    public Orange() {
        this.code = ORANGE_CODE;
        this.price = ORANGE_VALUE;
        this.sugar = 0;
        this.isHot = false;
    }
}
