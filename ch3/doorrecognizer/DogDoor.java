package ch3.doorrecognizer;

public class DogDoor {

	private boolean open;

	public DogDoor() {
		this.open = false;
	}

	public void open() {
		System.out.println("The dog door opens.");
		open = true;
	}

	public void close() {
		System.out.println("The dog door closes.");
		open = false;
	}

	public boolean isOpen() {
		return open;
	}

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
	    BarkRecognizer recognizer = new BarkRecognizer(door);
	    Remote remote = new Remote(door);

	    // Simulate the hardware hearing a bark
	    System.out.println("Fido barks to go outside...");
	    recognizer.recognize("Woof");

	    System.out.println("\nFido has gone outside...");
	    System.out.println("\nFido's all done...");

	    try {
	      Thread.sleep(10000);
	    } catch (InterruptedException e) { }

	    System.out.println("...but he's stuck outside!");

	    System.out.println("\nFido starts barking...");
	    recognizer.recognize("Woof");

	    System.out.println("\nFido's back inside...");
	}
}