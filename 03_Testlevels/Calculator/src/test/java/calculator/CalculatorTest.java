package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void addition(){
        Assertions.assertEquals(2, calculator.add(1, 1));
    }
}
