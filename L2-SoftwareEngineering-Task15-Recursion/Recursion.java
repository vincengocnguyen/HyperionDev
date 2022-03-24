
public class Recursion {
    /** Method to reverse string recursively */
    public static String reverse(String str) {
        // Base case
        if (str.isEmpty()) {
            return str;
        }
        // Test the recursive
        System.out.println(str.substring(1) + str.charAt(0));

        // Stack the first char to the end, then use the method to the remaining string > repeat
        return reverse(str.substring(1)) + str.charAt(0);
    }

    /** Method to return the nth fibonacci number */
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else 
            return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    public static void main(String[] args) {
        // Main programme for reversing string
        String str = "Hello World!";
        String reversed = reverse(str);
        System.out.println("The reversed string is " + reversed);

        // Main programme for fibonacci sequence
        int n = 10;
        System.out.printf("The first %d fibonacci sequence is: \n", n);
        for (int i = 0; i < n; i ++)
            System.out.println(fibonacci(i));
    }
}
