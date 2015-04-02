package ch4.maria;

import java.util.List;

public class BarkRecognizer {

	private DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(Bark bark) {
		System.out.println("   BarkRecognizer: Heard a '" + bark.getSound() + "'");

		for (Bark allowedBark : door.getAllowedBarks()) {
			if (allowedBark.equals(bark)) {
				door.open();
				return;
			}
		}
		
		System.out.println("Thsi dog is not allowed.");
	}
}