package ch5.rickstart;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List<Guitar> guitars = new LinkedList<>();

	public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
		guitars.add(new Guitar(serialNumber, price, spec));
	}

	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitars) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	public List<Guitar> search(GuitarSpec searchSpec) {
		List<Guitar> matchingGuitars = new LinkedList<>();
		for (Guitar guitar : guitars) {
			if (guitar.getSpec().matches(searchSpec))
				matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}
}