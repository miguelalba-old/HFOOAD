package ch10;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {
	private PrintStream out;

	public SubwayPrinter(OutputStream out) {
		this.out = new PrintStream(out);
	}

	public void printDirections(List<Connection> route) {
		Connection connection = route.get(0);
		String currentLine = connection.getLineName();
		String previousLine = currentLine;

		out.println("Start out at " + connection.getStation2().getName() + ".");
		out.println("Get on the " + currentLine + " heading towards "
				+ connection.getStation2().getName() + ".");

		for (int i = 1; i < route.size(); i++) {
			connection = route.get(i);
			currentLine = connection.getLineName();
			if (currentLine.equals(previousLine)) {
				out.println("  Continue past  "
						+ connection.getStation1().getName() + "...");
			} else {
				out.println("When you get to "
						+ connection.getStation1().getName() + ", get off the "
						+ previousLine + ".");
				out.println("Switch over to the " + currentLine
						+ ", heading towards "
						+ connection.getStation2().getName() + ".");
				previousLine = currentLine;
			}
		}
		out.println("Get off at " + connection.getStation2().getName()
				+ " and enjoy yourself!");
	}
}
