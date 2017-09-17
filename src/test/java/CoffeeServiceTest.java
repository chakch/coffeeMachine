import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


/**
 * Created by abdellatif on 16/09/2017.
 */

public class CoffeeServiceTest {


    @Before
    public void resetCounting() {
        MockitoAnnotations.initMocks(this);
        RepoData.resetCounting();
    }
    @Test
    public void whenCustomerMadeACoffeWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C::", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeACoffeWithOneSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C:1:1", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeACoffeWithTwoSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 2));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("C:2:1", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeATeeWithtoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("T", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("T::", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeATeeWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("T", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("T:1:1", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeAChocolateWithoutSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("H", 0));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("H::", coffeeService.getInformationMessage());
    }

    @Test
    public void whenCustomerMadeAChocolateWithSugar() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("H", 1));
        coffeeService.prepareDrinkCommand();
        Assert.assertEquals("H:1:1", coffeeService.getInformationMessage());
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
        Assert.assertEquals("M:the missing amount is 0,5", coffeeService.getInformationMessage());
    }

    @Test
    public void whenClientOrdreCoffeeWithAmountShowInformationMessage() {
        CoffeeService coffeeService = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        coffeeService.getCommandInfo();
        Assert.assertEquals("C:1:1", coffeeService.getInformationMessage());
    }

    @Test
    public void whenClientOrderOrangeJuice() {
        CoffeeService coffeeService = new CoffeeService(new Orange(), 0.6);
        coffeeService.getCommandInfo();
        Assert.assertEquals("O::", coffeeService.getInformationMessage());

    }

    @Test
    public void whenClientOrderHotCoffee() {
        CoffeeService coffeeService = new CoffeeService(new Coffee(0, true), 0.6);
        coffeeService.getCommandInfo();
        Assert.assertEquals("Ch::", coffeeService.getInformationMessage());

    }

    @Test
    public void countcoffeeOrdered() {
        CoffeeService coffeeServiceOne = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        CoffeeService coffeeServiceTwo = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        CoffeeService coffeeServiceThree = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);

        Assert.assertEquals(Integer.valueOf(3), RepoData.getNumberOfDrink());
    }

    @Test
    public void whenCustomersOrderThreeCoffee() {
        CoffeeService coffeeServiceOne = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        CoffeeService coffeeServiceTwo = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        CoffeeService coffeeServiceThree = new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);

        Assert.assertEquals(Double.valueOf(1.8), RepoData.getDrinkCountMap().get("C"));
    }

    @Test
    public void whenCustomersOrderMixedCommand() {
        new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("T", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("H", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("O", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("O", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("D", 1), 1.0);


        Assert.assertEquals(Double.valueOf(1.2), RepoData.getDrinkCountMap().get("C"));
        Assert.assertEquals(Double.valueOf(0.4), RepoData.getDrinkCountMap().get("T"));
        Assert.assertEquals(Double.valueOf(0.5), RepoData.getDrinkCountMap().get("H"));
        Assert.assertEquals(Double.valueOf(1.2), RepoData.getDrinkCountMap().get("O"));

    }

    @Test
    public void summaryOfAllDayCommand() {
        new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("C", 1), 1.0);
        new CoffeeService(CoffeeFactory.getDrinkClass("T", 1), 1.0);

        Assert.assertEquals("Tea: 0,4$ Coffee: 1,2$ ", RepoData.getSummary());

    }


}
