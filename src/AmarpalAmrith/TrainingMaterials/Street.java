package AmarpalAmrith.TrainingMaterials;

import java.util.*;

public class Street {

    private List<Integer> streetOfHouses;
    private List<Integer> leftHouses;
    private List<Integer> rightHouses;

    public Street(List<Integer> streetOfHouses, List<Integer> leftHouses, List<Integer> rightHouses) {
        this.streetOfHouses = streetOfHouses;
        this.leftHouses = leftHouses;
        this.rightHouses = rightHouses;
    }


    public List<Integer> getStreetOfHouses() {
        return streetOfHouses;
    }

    public List<Integer> getLeftHouses() {
        return leftHouses;
    }

    public List<Integer> getRightHouses() {
        return rightHouses;
    }

    public int getNumberOfHouses() {
        return streetOfHouses.size();
    }

    public List<Integer> getOneSideAtATime() {
        List<Integer> allHouses = new ArrayList<>();
        allHouses.addAll(leftHouses);
        allHouses.addAll(rightHouses);
        return allHouses;
    }

    public int getNumberOfCrossingsAllHousesAtOnce() {
        if (leftHouses.size() == rightHouses.size()) {
            return leftHouses.size() * 2 - 1;
        } else if (leftHouses.size() > rightHouses.size()) {
            return rightHouses.size() * 2;
        } else {
            return leftHouses.size() * 2;
        }
    }
}
