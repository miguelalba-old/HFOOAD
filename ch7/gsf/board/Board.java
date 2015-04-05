package ch7.gsf.board;

import java.util.ArrayList;
import java.util.List;

import ch7.gsf.unit.Unit;

public class Board {
	
	private int width, height;
	private List<List<Tile>> tiles;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		initialize();
	}
	
	private void initialize() {
		tiles = new ArrayList<>(width);
		for (int i = 0; i < width; i++) {
			List<Tile> tile = new ArrayList<>(height);
			for (int j = 0; j < height; j++) {
				tile.add(new Tile());
			}
			tiles.add(tile);
		}
	}
	
	public Tile getTile(int x, int y) {
		return tiles.get(x-1).get(y-1);
	}
	
	public void addUnit(Unit unit, int x, int y) {
		getTile(x, y).addUnit(unit);
	}
	
	public void removeUnit(Unit unit, int x, int y) {
		getTile(x, y).removeUnit(unit);
	}
	
	public void removeUnits(int x, int y) {
		getTile(x, y).removeUnits();
	}
	
	public List<Unit> getUnits(int x, int y) {
		return getTile(x, y).getUnits();
	}
}
