import java.io.*;
/**
 * PizzaAnalyzer demonstrates the use of a binary decision tree to
 * diagnose back pain.
 */
public class PizzaAnalyzer
{
    /**
     *  Asks questions of the user to diagnose a pizza.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("So you found some pizza, is it delicious?");
        DecisionTree expert = new DecisionTree("deliciousPizza.txt");
        expert.evaluate();
    }
}