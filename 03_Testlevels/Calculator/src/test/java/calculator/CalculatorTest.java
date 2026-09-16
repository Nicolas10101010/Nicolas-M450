package calculator;

import org.junit.jupiter.api.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void addition(){
        Assertions.assertEquals(2, calculator.add(1, 1));
    }
}
