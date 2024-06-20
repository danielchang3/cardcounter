import java.util.Scanner;
import java.lang.Math;

public class CardCounter{

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int decks = 0;
    int count = 0;
    int runningCount = 0;
    float trueCount = 0;

    String input;

    System.out.println("Hi, this is the cardcounter!");
    System.out.println("Enter the number decks in the shoe:");
    decks = scanner.nextInt();
    System.out.println("Cards '2-6' are low, '7-9' are mid, and '10-A' are high");
    while (true) {
        input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("x")) {
            break;
        }

        switch (input) {
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                runningCount++;
                break;
            case "7":
            case "8":
            case "9":
                // Neutral cards, no change to count
                break;
            case "10":
            case "J":
            case "Q":
            case "K":
            case "A":
                runningCount--;
                break;
            default:
                System.out.println("Invalid input. Please enter a valid card detail or 'x' to exit.");
                continue;
        }
        count++;
        trueCount = setTrueCount(count, runningCount, decks);
        System.out.println("Running count: " + runningCount);
        System.out.println("Card count: " + count);
        System.out.println("The current true count is: " + trueCount);
    }

        System.out.println("Exiting card counter. Final values:");
        System.out.println("Number of cards: " + count);
        System.out.println("Running count: " + runningCount);
        System.out.println("True count: " + trueCount);
        scanner.close();
}
    public static float setTrueCount(Integer count, Integer runningCount, Integer decks) {
        return (float) runningCount / (decks - (int)(Math.floor(count - 51)));
    }
}
