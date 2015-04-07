package ch10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Subway {
	private List<Station> stations = new LinkedList<>();
	private List<Connection> connections = new LinkedList<>();
	private Map<Station, List<Station>> network = new HashMap<>();

	public void addStation(String stationName) {
		if (!this.hasStation(stationName)) {
			Station station = new Station(stationName);
			stations.add(station);
		}
	}

	public boolean hasStation(String stationName) {
		return stations.contains(new Station(stationName));
	}

	public void addConnection(String station1Name, String station2Name,
			String lineName) {
		if ((this.hasStation(station1Name)) && (this.hasStation(station2Name))) {
			Station station1 = new Station(station1Name);
			Station station2 = new Station(station2Name);
			Connection connection = new Connection(station1, station2, lineName);
			connections.add(connection);
			connections.add(new Connection(station2, station1, connection
					.getLineName()));

			addToNetwork(station1, station2);
			addToNetwork(station2, station1);
		} else {
			throw new RuntimeException("Invalid connection: [" + station1Name
					+ ", " + station2Name + ", " + lineName + "]");
		}
	}

	private void addToNetwork(Station station1, Station station2) {
		if (network.keySet().contains(station1)) {
			List<Station> connectingStations = network.get(station1);
			if (!connectingStations.contains(station2)) {
				connectingStations.add(station2);
			}
		} else {
			List<Station> connectingStations = new LinkedList<>();
			connectingStations.add(station2);
			network.put(station1, connectingStations);
		}
	}

	public List<Connection> getDirections(String startStationName,
			String endStationName) {
		if (!this.hasStation(startStationName)
				|| !this.hasStation(endStationName)) {
			throw new RuntimeException(
					"Stations entered do not exist on this subway");
		}

		Station start = new Station(startStationName);
		Station end = new Station(endStationName);
		List<Connection> route = new LinkedList<>();
		List<Station> reachableStations = new LinkedList<>();
		Map<Station, Station> previousStations = new HashMap<>();
		List<Station> neighbors = network.get(start);

		for (Station station : neighbors) {
			if (station.equals(end)) {
				route.add(getConnection(start, end));
				return route;
			} else {
				reachableStations.add(station);
				previousStations.put(station, start);
			}
		}

		// TODO: Replace next 2 lines with: List<Station> nextStations = new
		// LinkedList<>(neighbors);
		List<Station> nextStations = new LinkedList<>();
		nextStations.addAll(neighbors);
		Station currentStation = start;

		searchLoop: for (int i = 1; i < stations.size(); i++) {
			List<Station> tmpNextStations = new LinkedList<>();
			for (Station station : nextStations) {
				reachableStations.add(station);
				currentStation = station;
				List<Station> currentNeighbors = network.get(currentStation);
				for (Station neighbor : currentNeighbors) {
					if (neighbor.equals(end)) {
						reachableStations.add(neighbor);
						previousStations.put(neighbor, currentStation);
						break searchLoop;
					} else if (!reachableStations.contains(neighbor)) {
						reachableStations.add(neighbor);
						tmpNextStations.add(neighbor);
						previousStations.put(neighbor, currentStation);
					}
				}
			}
			nextStations = tmpNextStations;
		}

		// We've found the path now!
		boolean keepLooping = true;
		Station keyStation = end;
		Station station;

		while (keepLooping) {
			station = (Station) previousStations.get(keyStation);
			route.add(0, getConnection(station, keyStation));
			if (start.equals(station)) {
				keepLooping = false;
			}
			keyStation = station;
		}

		return route;
	}

	private Connection getConnection(Station station1, Station station2) {
		for (Connection connection : connections) {
			Station one = connection.getStation1();
			Station two = connection.getStation2();
			if ((station1.equals(one)) && station2.equals(two)) {
				return connection;
			}
		}
		return null;
	}

	public boolean hasConnection(String station1Name, String station2Name,
			String lineName) {
		Station station1 = new Station(station1Name);
		Station station2 = new Station(station2Name);

		for (Connection connection : connections) {
			if (connection.getLineName().equalsIgnoreCase(lineName)) {
				if ((connection.getStation1().equals(station1))
						&& (connection.getStation2().equals(station2))) {
					return true;
				}
			}
		}

		return false;
	}

}
