import java.util.*;

public class Optional {
    public static String replace(String text, String oldString, String newString) {
        if (text.isEmpty())     // Base case, the string is empty
            return "";
        // If the string starts with oldString, then return  newString, and recursively use the method for the rest of the string
        else if (text.startsWith(oldString))        
            return (newString + replace(text.substring(oldString.length()), oldString, newString));
        // If not, then continue with the next character
        else
            return (text.substring(0, 1) + replace(text.substring(1), oldString, newString));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a string: ");
        String text = input.nextLine();

        System.out.println("Please  enter the substring you wish to find: ");
        String oldString = input.nextLine();

        System.out.println("PPlease enter a string to replace the given substring: ");
        String newString = input.nextLine();

        System.out.println("Your new string is: " + replace(text, oldString, newString));
    }
}