package AmarpalAmrith.TrainingMaterials;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Street street = StreetFileParser.getStreet("1 2 3 5 4 6 8 7 9 10 11 12 13 15");

        Street shortStreet = StreetFileParser.getStreet("1");
        Street strangeStreet = StreetFileParser.getStreet("1 3 5 2 4 6");

        List<Street> streetList = new ArrayList<>();

        streetList.add(street);
        streetList.add(shortStreet);
        streetList.add(strangeStreet);

        for (Street s : streetList) {
            System.out.println(s.getStreetOfHouses());
            System.out.println("Left: " + s.getLeftHouses());
            System.out.println("Right: " + s.getRightHouses());
            System.out.println("Count: " + s.getNumberOfHouses());
            System.out.println("Number of Crossings: " + s.getNumberOfCrossings());
            System.out.println("Route one side at a time" + s.getOneSideAtATime());
            System.out.println("======================");
        }
    }
}
