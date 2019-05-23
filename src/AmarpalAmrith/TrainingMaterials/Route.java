package AmarpalAmrith.TrainingMaterials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {

    private List<Integer> route;

    private Route(List<Integer> route) {
        this.route = route;
    }

    public List<Integer> getRoute() {
        return route;
    }

    public int getNumberOfCrossings() {
        int counter = 0;
        for (int i = 1; i < route.size(); i++) {
            if (Math.abs(route.get(i) - route.get(i - 1)) != 2) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
    public static Route createSequentialRoute(Street street) {
        return new Route(street.getStreetOfHouses());
    }

    public static Route createOneSideAtATime(Street street) {
        List<Integer> allHouses = new ArrayList<>();
        List<Integer> rightHousesReversed = new ArrayList<>(street.getRightHouses());

        Collections.reverse(rightHousesReversed);

        allHouses.addAll(street.getLeftHouses());
        allHouses.addAll(rightHousesReversed);

        return new Route(allHouses);
    }
}
