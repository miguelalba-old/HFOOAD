package ch7.gsf.board;

import java.util.LinkedList;
import java.util.List;

import ch7.gsf.unit.Unit;

public class Tile {

	private List<Unit> units = new LinkedList<>();
	
	protected void addUnit(Unit unit) {
		units.add(unit);
	}
	
	protected void removeUnit(Unit unit) {
		units.remove(unit);
	}
	
	protected List<Unit> getUnits() {
		return units;
	}
	
	protected void removeUnits() {
		units.clear();
	}
}
