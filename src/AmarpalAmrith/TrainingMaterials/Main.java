package AmarpalAmrith.TrainingMaterials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("sample.txt"));
        System.out.println(list.toString());
        Street streetFile = StreetFileParser.getStreet(String.join(" ", list));
        Street street = StreetFileParser.getStreet("1 2 3 5 4 6 8 7 9 10 11 12 13 15");

        Street shortStreet = StreetFileParser.getStreet("1");
        Street strangeStreet = StreetFileParser.getStreet("1 3 5 7 9 11 13 15 2");
        Street longStreet = StreetFileParser.getStreet("1 2 3 4 6 8 5 7 9 ");

        List<Street> streetList = new ArrayList<>();

        streetList.add(street);
        streetList.add(shortStreet);
        streetList.add(strangeStreet);
        streetList.add(longStreet);
        streetList.add(streetFile);

        for (Street s : streetList) {
            Route routeSequential = Route.createSequentialRoute(s);
            Route routeOneSideAtATime = Route.createOneSideAtATime(s);
            System.out.println("Route (Sequential) " + routeSequential.getRoute().toString());
            System.out.println("Route (One Street At A Time) " + routeOneSideAtATime.getRoute().toString());
            System.out.println("Route (Sequential) Number of Crossings: " + routeSequential.getNumberOfCrossings());
            System.out.println("Route (One Street At A Time) Number of Crossings: " + routeOneSideAtATime.getNumberOfCrossings());
            System.out.println("================================");
        }
    }
}
