/** Lion subclass */
public class Lion extends Animal {
	String type;

	public Lion(int numTeeth, boolean spots, int weight) {
		super(numTeeth, spots, weight);
	}
	
	public String getType() {
		return type;
	}

	/** Method to set the type of Lion object */
	public void setType() {
		int lionWeight = super.weight;

		if (lionWeight < 80) {
			this.type = "cub";
		}
		else if (lionWeight < 120) {
			this.type = "female";
		}
		else if (lionWeight >= 120) {
			this.type = "male";
		}
	}

	public void printLion() {
		System.out.println("\nLion");
		System.out.println("Number of teeh: " + getNumTeeth());
		System.out.println("Spots: " + getSpots());
		System.out.println("Weight: " + getWeight());
		System.out.println("Type: " + getType());
	}
}
