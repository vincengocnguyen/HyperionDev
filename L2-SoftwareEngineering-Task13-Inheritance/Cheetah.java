import java.util.*;

/** Cheetah subclass */
public class Cheetah extends Animal {
	String[] type;

	public Cheetah(int numTeeth, boolean spots, int weight) {
		super(numTeeth, spots, weight);
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String toString()        // Returns objects values
	{
		String output = "\nCheetah";
		output += "\nNumber of teeth: " + numTeeth;
		output += "\nSpots: " + spots;
		output += "\nWeight: " + weight;
		output += "\nType: " + Arrays.toString(type);
		return output;
	}
}