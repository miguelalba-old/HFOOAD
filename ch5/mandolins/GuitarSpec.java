package ch5.mandolins;

public class GuitarSpec extends InstrumentSpec {

	private int numStrings;

	public GuitarSpec(Builder builder, String model, Type type, int numStrings,
		Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.numStrings = numStrings;
	}

	public int getNumStrings() {
		return numStrings;
	}

	// Override the superclass matches()
	public boolean matches(InstrumentSpec otherSpec) {
		if (!super.matches(otherSpec))
			return false;
		if (!(otherSpec instanceof GuitarSpec))
			return false;
		if (numStrings != ((GuitarSpec)otherSpec).numStrings)
			return false;
		return true;
	}
}