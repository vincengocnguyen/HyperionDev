import java.util.*;

public class BubbleSort {
    public static void main(final String[] args) {
        //Initialise the ArrayList variable
        final ArrayList<String> arr = new ArrayList<String>();
        arr.add("right");
        arr.add("subdeued");
        arr.add("trick");
        arr.add("crayon");
        arr.add("punishment");
        arr.add("silk");
        arr.add("describe");
        arr.add("royal");
        arr.add("prevent");
        arr.add("slope");

        // Implement Bubble Sort
        for (int i = (arr.size() - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if ( arr.get(j - 1).compareTo(arr.get(j)) > 0 ) {
                    String temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                } 
            }
        }

        // Print the sorted ArrayList
        System.out.println(arr);
    }
}