namespace calculator;

public class Calculator
{
    public double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount)
    {
        double addon_discount;
        double result;

        if (extras >= 5)
        {
            addon_discount = 15;
        }
        else if (extras >= 3)
        {
            addon_discount = 10;
        }
        else
        {
            addon_discount = 0;
        }

        if (discount > addon_discount)
        {
            addon_discount = discount;
        }

        result = baseprice / 100.0 * (100 - discount) + specialprice + extraprice / 100.0 * (100 - addon_discount);

        return result;
    }

    public bool test_calculate_price()
    {
        double price;
        
        price = calculatePrice(100, 50, 20, 2, 5);
        var testOk = (price == 100 / 100.0 * (100 - 5) + 50 + 20 / 100.0 * (100 - 5));

        return testOk;
    }
}