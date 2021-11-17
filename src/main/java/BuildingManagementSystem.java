import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuildingManagementSystem {
	private List<Building> buildings;

	public BuildingManagementSystem() {
		this.buildings = new ArrayList<>();
	}

	public List<Building> getBuildings() {
		return List.copyOf(this.buildings);
	}

	public UUID addBuilding(String name) {
		Building building = new Building(name);
		this.buildings.add(building);
		return building.getID();
	}

	public void removeBuilding(UUID id) {
		int idxToRemove = -1;
		for (int i = 0; i < this.buildings.size(); i++) {
			if (this.buildings.get(i).getID().equals(id)) {
				idxToRemove = i;
				break;
			}
		}
		if (idxToRemove == -1) return;
		this.buildings.remove(idxToRemove);
	}
}
