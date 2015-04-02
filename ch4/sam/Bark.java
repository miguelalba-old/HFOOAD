package ch4.sam;

public class Bark {

	private String sound;

	public Bark(String bark) {
		sound = bark;
	}

	public String getSound() {
		return sound;
	}

	public boolean equals(Object bark) {
		if (bark instanceof Bark) {
			Bark otherBark = (Bark) bark;
			if (this.sound.equalsIgnoreCase(otherBark.sound)) {
				return true;
			}
		}
		return false;
	}
}