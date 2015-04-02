package ch5.mandolins;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List<Instrument> inventory = new LinkedList<>();

	public void addInstrument(String serialNumber, double price,
		InstrumentSpec spec) {
		if (spec instanceof GuitarSpec) {
			inventory.add(new Guitar(serialNumber, price, (GuitarSpec)spec));
		} else if (spec instanceof MandolinSpec) {
			inventory.add(new Mandolin(serialNumber, price, (MandolinSpec)spec));
		}
	}

	public Instrument get(String serialNumber) {
		for (Instrument instrument : inventory) {
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		return null;
	}

	public List<Guitar> search(GuitarSpec searchSpec) {
		List<Guitar> matchingGuitars = new LinkedList<>();
		for (Instrument instrument : inventory) {
			Guitar guitar = (Guitar) instrument;
			if (guitar.getSpec().matches(searchSpec))
				matchingGuitars.add(guitar);
		}
		return matchingGuitars;
	}

	public List<Mandolin> search(MandolinSpec searchSpec) {
		List<Mandolin> matchingMandolins = new LinkedList<>();
		for (Instrument instrument : inventory) {
			Mandolin mandolin = (Mandolin) instrument;
			if (mandolin.getSpec().matches(searchSpec))
				matchingMandolins.add(mandolin);
		}
		return matchingMandolins;
	}
}