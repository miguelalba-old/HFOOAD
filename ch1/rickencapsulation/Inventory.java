package ch1.rickencapsulation;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private LinkedList<Guitar> guitars;

	public Inventory() {
		guitars = new LinkedList<>();
	}

	public void addGuitar(String serialNumber, double price, Builder builder,
		String model, Type type, Wood backWood, Wood topWood) {
		Guitar guitar = new Guitar(serialNumber, price, builder, model, type,
			backWood, topWood);
		guitars.add(guitar);
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
			GuitarSpec guitarSpec = guitar.getSpec();

			if (searchSpec.getBuilder() != guitarSpec.getBuilder())
				continue;

			String model = searchSpec.getModel().toLowerCase();
			if ((model != null) && (!model.equals("")) &&
				(!model.equals(guitarSpec.getModel().toLowerCase())))
				continue;

			if (searchSpec.getType() != guitarSpec.getType())
				continue;

			if (searchSpec.getBackWood() != guitarSpec.getBackWood())
				continue;

			if (searchSpec.getTopWood() != guitarSpec.getTopWood())
				continue;
			matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}
}