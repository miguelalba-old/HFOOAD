package ch9.original;

import java.util.*;

public class UnitGroup {

	private Map<Integer, Unit> units = new HashMap<>();
	
	public UnitGroup(List<Unit> unitList) {
		for (Unit unit : unitList) {
			units.put(unit.getId(), unit);
		}
	}
	
	public void addUnit(Unit unit) {units.put(unit.getId(), unit);}
	public void removeUnit(int id) {units.remove(id);}
	public Unit getUnit(int id) {return (Unit)units.get(id);}
	
	public List<Unit> getUnits() {
		return new LinkedList<Unit>(units.values());
	}	
}
