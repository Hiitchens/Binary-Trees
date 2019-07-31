import java.io.*;
/**
 * CarPurchaseCatalog demonstrates the use of a binary decision tree to
 * diagnose back pain.
 */
public class CarPurchaseCatalogue
{

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Welcome to ACME motors!");

        DecisionTree expert = new DecisionTree("carSelect.txt");
        expert.evaluate();
    }
}
