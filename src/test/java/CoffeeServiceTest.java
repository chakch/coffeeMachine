import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abdellatif on 16/09/2017.
 */

public class CoffeeServiceTest {
    @Test
    public void whenCustomerMadeACoffeWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.COFFRE_CODE, 0);
        coffeeService.prepareCommand();
        Assert.assertEquals("C::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeACoffeWithOneSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.COFFRE_CODE, 1);
        coffeeService.prepareCommand();
        Assert.assertEquals("C:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeACoffeWithTwoSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.COFFRE_CODE, 2);
        coffeeService.prepareCommand();
        Assert.assertEquals("C:2:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeATeeWithtoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.TEA_CODE, 0);
        coffeeService.prepareCommand();
        Assert.assertEquals("T::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeATeeWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.TEA_CODE, 1);
        coffeeService.prepareCommand();
        Assert.assertEquals("T:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeAChocolateWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.CHOCOLATE_CODE, 0);
        coffeeService.prepareCommand();
        Assert.assertEquals("H::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeAChocolateWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.CHOCOLATE_CODE, 1);
        coffeeService.prepareCommand();
        Assert.assertEquals("H:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCommandIsNotValid() {
        CoffeeService coffeeService = new CoffeeService("X", 1);
        Assert.assertFalse(coffeeService.verifieCommand());

    }

    @Test
    public void whenCommandIsValid() {
        CoffeeService coffeeService = new CoffeeService(CoffeeService.COFFRE_CODE, 1);
        Assert.assertTrue(coffeeService.verifieCommand());
    }

}
