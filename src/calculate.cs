namespace test
{
    class Calculation
    {
        double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;
        
        if (extras >= 3) 
            addon_discount = 10;
        else if (extras >= 5)
            addon_discount = 15;
        else 
            addon_discount = 0;
        
        if (discount > addon_discount)
            addon_discount = discount;
        
        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-addon_discount);
        
        return result;
        }
    

    boolean test_calculate_price(){

    double price;
    boolean test_ok = true;

    price = calculatePrice(100, 50, 20, 4, 5);
    if (price != 100.0) {
        test_ok = false;
    }
    return test_ok;
    }
    
    }
}