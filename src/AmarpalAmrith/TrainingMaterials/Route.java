package AmarpalAmrith.TrainingMaterials;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Street street;

    public Route(Street street) {
        this.street = street;
    }

    public Street getStreet() {
        return street;
    }

    public int getNumberOfCrossingsAllHousesAtOnce() {
        if (street.getLeftHouses().size() == street.getRightHouses().size()) {
            return street.getLeftHouses().size() * 2 - 1;
        } else if (street.getLeftHouses().size() > street.getRightHouses().size()) {
            return street.getRightHouses().size() * 2;
        } else {
            return street.getLeftHouses().size() * 2;
        }
    }
    public List<Integer> getOneSideAtATime() {
        List<Integer> allHouses = new ArrayList<>();
        allHouses.addAll(street.getLeftHouses());
        allHouses.addAll(street.getRightHouses());
        return allHouses;
    }
    public int get
}
