import java.io.*;
/**
 * AnimalAnalysis demonstrates the use of a binary decision tree to
 * diagnose back pain.
 */
public class AnimalAnalysis
{
    /**
     *  Asks questions of the user to diagnose a medical problem.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("What kind of animal is it?");
        DecisionTree expert = new DecisionTree("animalAnalyser.txt");
        expert.evaluate();
    }
}