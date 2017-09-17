import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abdellatif on 16/09/2017.
 */

public class CoffeeServiceTest {
    @Test
    public void whenCustomerMadeACoffeWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeACoffeWithOneSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeACoffeWithTwoSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 2));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C:2:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeATeeWithtoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("T", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("T::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeATeeWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("T", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("T:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeAChocolateWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("H", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("H::", coffeeService.getCommand());
    }

    @Test
    public void whenCustomerMadeAChocolateWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("H", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("H:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenCommandIsNotValid() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("X", 1));
        Assert.assertFalse(coffeeService.verifieCommand());

    }

    @Test
    public void whenCommandIsValid() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1));
        Assert.assertTrue(coffeeService.verifieCommand());
    }

    @Test
    public void whenClientOrdreCoffeeWithTHeExactamountOrMore() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        Assert.assertTrue(coffeeService.checkInputMoney());
    }

    @Test
    public void whenClientOrdreCoffeeWithMissingAmount() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 0.1);
        Assert.assertFalse(coffeeService.checkInputMoney());
    }

    @Test
    public void whenClientOrdreCoffeeWithMissingAmountShowInformationMessage() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 0.1);
        coffeeService.getCommandInfo();
        Assert.assertEquals("M:the missing amount is 0,5", coffeeService.getCommand());
    }

    @Test
    public void whenClientOrdreCoffeeWithAmountShowInformationMessage() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        coffeeService.getCommandInfo();
        Assert.assertEquals("C:1:1", coffeeService.getCommand());
    }

    @Test
    public void whenClientOrderOrangeJuice() {
        CoffeeService coffeeService = new CoffeeService(new Orange(), 0.6);
        coffeeService.getCommandInfo();
        Assert.assertEquals("O::", coffeeService.getCommand());

    }

    @Test
    public void whenClientOrderHotCoffee() {
        CoffeeService coffeeService = new CoffeeService(new Coffee(0, true), 0.6);
        coffeeService.getCommandInfo();
        Assert.assertEquals("Ch::", coffeeService.getCommand());

    }

}
