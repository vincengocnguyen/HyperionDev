import java.io.*;
import java.text.Format;
import java.util.*;

public class MyFile {
    /** Method to calculate sum */
    static int sum(int[] arr) {
        int sum = 0;
        int i;

        for (i = 0; i < arr.length; i ++)
            sum += arr[i];
        
        return sum;
    }

    /** Method to calculate average */
    static float avg(int[] arr) {
        int sumArr = sum(arr);
        float avg = (float) sumArr / arr.length;

        return avg;
    }

    public static void main(String args[]) throws FileNotFoundException {
        try {
            // Create Scanner object for the input file
            File input = new File("/Volumes/GoogleDrive/My Drive/Engineering/HyperionDev/Introduction to Software Engineering/Task 14/input.txt");  

            Scanner sc = new Scanner(input);

            // Create Formatter object for the output file
            Formatter output = new Formatter("/Volumes/GoogleDrive/My Drive/Engineering/HyperionDev/Introduction to Software Engineering/Task 14/output.txt");

            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();       // Store each line in a String

                String[] inputArray = inputLine.split(":");     // Split the String into an array 
                String operation = inputArray[0];       // The first element of the array is the operation

                String[] numbersString = inputArray[1].split(",");      // Split the second element into an array of numbers


                int[] numbers = new int[numbersString.length];
                for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Integer.parseInt(numbersString[i]);        // Convert the string number array to int array
                }
                Arrays.sort(numbers);       // Sort the array

                if (operation.equalsIgnoreCase("min")) {
                    output.format("The %s of %s is %s\n", operation, Arrays.toString(numbersString), numbers[0]);
                }
                else if (operation.equalsIgnoreCase("max")) {
                    output.format("The %s of %s is %s\n", operation, Arrays.toString(numbersString), numbers[numbers.length - 1]);
                }
                else if (operation.equalsIgnoreCase("avg")) {
                    output.format("The %s of %s is %s\n", operation, Arrays.toString(numbersString), avg(numbers));
                }
                else if (operation.equalsIgnoreCase("sum")) {
                    output.format("The %s of %s is %s\n", operation, Arrays.toString(numbersString), sum(numbers));
                }
                else if (operation.startsWith("P")) {
                    String percentileStr = operation.substring(1, 3);       // Scan for the percentile input
                    int percentile = Integer.parseInt(percentileStr);
                    int index = percentile * numbersString.length / 100;        // Calculate the percentile index
                    output.format("%s %s",percentile, index);
                    output.format("The %s of %s is %s\n", operation, Arrays.toString(numbersString), numbers[index - 1]);
                }
            }

            sc.close();
            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.print("File not found.");
        }
    }
}