package ch5.cohesive;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

	private List<Instrument> inventory = new LinkedList<>();

	public void addInstrument(String serialNumber, double price,
		InstrumentSpec spec) {
		inventory.add(new Instrument(serialNumber, price, spec));
	}

	public Instrument get(String serialNumber) {
		for (Instrument instrument : inventory) {
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		return null;
	}

	public List<Instrument> search(InstrumentSpec searchSpec) {
		List<Instrument> matchingInstruments = new LinkedList<>();
		for (Instrument instrument : inventory) {
			if (instrument.getSpec().matches(searchSpec)) {
				matchingInstruments.add(instrument);
			}
		}
		return matchingInstruments;
	}
}