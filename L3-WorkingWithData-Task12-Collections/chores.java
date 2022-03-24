import java.util.*;

public class chores {
    public static void main(String[] args) {
        // Get the size as an input
        Scanner input = new Scanner(System.in);
        System.out.println("How many pairs of names and chores would you like to generate?");
        int size = input.nextInt();

        // Initialise the 2 lists
        ArrayList<String> names = new ArrayList<String>(size);
        String name;
        
        ArrayList<String> chores = new ArrayList<String>(size);
        String chore;

        // Enter names
        System.out.format("Enter %d names: ", size);
        System.out.println();

        for (int i = 0; i < size; i++) {
            name = input.next();
            names.add(name);            
        }

        System.out.println(names);

        // Enter chores
        System.out.format("\nEnter %d chores: \n", size);
        
        for (int i = 0; i < size; i++) {
            chore = input.next();
            chores.add(chore);
        }

        System.out.println(chores);

        // Shuffle lists
        Collections.shuffle(names);
        Collections.shuffle(chores);

        // Print results
        for (int i = 0; i < size; i++) {
            System.out.format("Pair #%d is %s and %s\n", (i+1), names.get(i), chores.get(i));
        }
    }
}