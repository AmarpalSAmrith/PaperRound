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

}
