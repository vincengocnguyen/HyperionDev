import java.util.*;

public class Application {
    public static void main (String [] args) {
		// Create a new Lion object
		Lion newLion = new Lion(20, false, 150);

		// Call the setType method;
		newLion.setType();

		// Print out the Lion object details
		newLion.printLion();

		// Create a new Cheetah object
		Cheetah newCheetah = new Cheetah(30, true, 150);

		// Set the type for the Cheetah object
		String[] cheetahType = {"Asiatic", "Puma"};
		newCheetah.setType(cheetahType);

		// Print out the Cheetah object detail
		System.out.println(newCheetah.toString());
	}
}