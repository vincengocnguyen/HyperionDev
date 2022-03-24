
public class GCDRecursion {
    /** Recursive function to find the GCD */
    public static int gcd(int x, int y) {
        int temp;
        if (x < y) {
            temp = x;
            x = y;
            y = temp;
        }

        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        int x = 312;
        int y = 88;

        System.out.printf(" The greatest common divisor of %d and %d is %d.", x, y, gcd(x, y));
    } 
}