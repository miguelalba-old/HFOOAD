package ch9.original;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface Weapon {
	public void attack();
}

class Sword implements Weapon {
	public void attack() {}
}

class Gun implements Weapon {
	public void attack() {}
}

class Club implements Weapon {
	public void attack() {}
}

public class Unit {
	
	private String type;
	private int id;
	private String name;
	private List<Weapon> weapons = new LinkedList<>();
	private Map<String, Object> properties = new HashMap<>();
	
	public Unit(int id) {this.id=id;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type=type;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public List<Weapon> getWeapons() {return weapons;}
	public void addWeapon(Weapon weapon) {weapons.add(weapon);}
	
	public int getId() {return id;}

	public void setProperty(String property, Object value) {
		properties.put(property, value);
	}
	
	public Object getProperty(String property) {
		return properties.get(property);
	}
}
	
