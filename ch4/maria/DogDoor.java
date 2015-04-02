package ch4.maria;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

	private boolean open = false;
	private List<Bark> allowedBarks = new LinkedList<>();

	public void addAllowedBark(Bark bark) {
		allowedBarks.add(bark);
	}

	public List<Bark> getAllowedBarks() {
		return allowedBarks;
	}

	public void open() {
		System.out.println("The dog door opens.");
		open = true;

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				close();
				timer.cancel();
			}
		}, 5000);
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
		door.addAllowedBark(new Bark("rowlf"));
		door.addAllowedBark(new Bark("rooowlf"));
		door.addAllowedBark(new Bark("rawlf"));
		door.addAllowedBark(new Bark("woof"));
		BarkRecognizer recognizer = new BarkRecognizer(door);
		Remote remote = new Remote(door);

		// Simulate the hardware hearing a bark
		System.out.println("Bruce starts barking.");
		recognizer.recognize(new Bark("Rowlf"));

		System.out.println("\nBruce has gone outside...");

		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) { }

		System.out.println("\nBruce all done...");
		System.out.println("...but he's stuck outside!");

		// Simulate the hardware hearing a bark (not Bruce!)
		Bark smallDogBark = new Bark("yip");
		System.out.println("A small dog starts barking");
		recognizer.recognize(smallDogBark);

		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) { }

		// Simulate the hardware hearing a bark again
		System.out.println("\nBruce starts barking.");
		recognizer.recognize(new Bark("Rowlf"));

		System.out.println("\nBruces' back inside...");
	}
}