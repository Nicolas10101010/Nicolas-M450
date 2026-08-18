namespace calculator;

public class program
{
    public static void Main(String[] args)
    {
        var calculator = new Calculator();
        var result = calculator.test_calculate_price();

        Console.WriteLine(result ? "Test passed" : "Test failed");
    }
}