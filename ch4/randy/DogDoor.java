package ch4.randy;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

	private boolean open;
	private String allowedBark;

	public DogDoor() {
		open = false;
	}

	public void setAllowedBark(String bark) {
		allowedBark = bark;
	}

	public String getAllowedBark() {
		return allowedBark;
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
	}

	public boolean isOpen() {
		return open;
	}

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		door.setAllowedBark("Rowlf");
		BarkRecognizer recognizer = new BarkRecognizer(door);
		Remote remote = new Remote(door);

		// Simulate the hardware hearing a bark
		System.out.println("Bruce starts barking.");
		recognizer.recognize("Rowlf");

		System.out.println("\nBruce has gone outside...");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}

		System.out.println("\nBruce all done...");
		System.out.println("...but he's stuck outside!");

		// Simulate the hardware hearing a bark (not Bruce!)
		System.out.println("\nBruce starts barking.");
		recognizer.recognize("Rowlf");

		System.out.println("\nBruce's back inside...");
	}
}