package textgeneration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MoneyTest {

    private Money money;

    @BeforeEach
    public void initializeTestObject () {
        money = new Money ();
    }

    @AfterEach
    public void cleaningUsedTestObject () {
        money = null;
    }

    @Test
    public void givenTheMoneyConstructor_WhenAmountAndCurrencyIsSet_ThenGetterReturnsExpectedValues () {
        money = new Money ( 10, "USD" );
        Assertions.assertEquals ( 10, money.getAmount (), "The amount which is set is 10. The values have to be equal!" );
        Assertions.assertEquals ( "USD", money.getCurrency (), "The currency which is set is USD. The values have to be equal!" );
    }
}
