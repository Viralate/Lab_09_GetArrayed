import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declare variables and scanner
        int[] dataPoints = new int[100];
        Random rand = new Random();
        int sum = 0;
        Scanner scanner = new Scanner(System.in); // Initialize Scanner here for use in SafeInput

        // Initialize random values and then display them
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1; // Chooses a random value between 1-100
            //print output
            System.out.print(dataPoints[i] + (i < dataPoints.length - 1 ? " | " : "\n"));
            sum += dataPoints[i];
        }

        // Calculate and display the sum and average
        double average = sum / (double) dataPoints.length;
        //print sum and average
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        // Linear scan for occurrences
        //declare int
        int targetValue = SafeInput.getRangedInt(scanner, "Enter a value between 1 and 100: ", 1, 100);
        int count = occurrenceScan(dataPoints, targetValue);
        //print results
        System.out.println("The value " + targetValue + " was found " + count + " times in the array.");

        // Find the first occurrence
        //declare int and print results 
        int position = findFirstOccurrence(dataPoints, targetValue);
        if (position != -1) {
            System.out.println("The value " + targetValue + " was found at array index " + position);
        } else {
            System.out.println("The value was not found in the array.");
        }

        // Min and max logic and print result
        int min = min(dataPoints);
        int max = max(dataPoints);
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    // Methods for array operations
    public static double getAverage(int[] values) {
        int sum = sum(values);
        return sum / (double) values.length;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) min = value;
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) max = value;
        }
        return max;
    }

    public static int occurrenceScan(int[] values, int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) count++;
        }
        return count;
    }

    public static int findFirstOccurrence(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) return i;
        }
        return -1; // Indicates not found
    }
}

// create safe input for invalid inputs and integers
class SafeInput {
    public static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        System.out.print(prompt);
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter a number.");
                scanner.next(); // Move scanner past the current input
                System.out.print(prompt);
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }
}
