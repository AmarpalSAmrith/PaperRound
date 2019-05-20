package AmarpalAmrith.TrainingMaterials;

import java.util.*;
import java.util.stream.Collectors;

import static AmarpalAmrith.TrainingMaterials.FileParser.*;
public class Street {

    private List<Integer> streetOfHouses;

    public Street(String file) {
        List<Integer> houses = new ArrayList<>();

        houses = convertFile(file);

        if (!isValidFile(houses)) {
            throw new IllegalArgumentException("This is not a valid file of house numbers");
        }
        streetOfHouses = houses;

    }

    public List<Integer> getOddHouses() {
        return streetOfHouses.stream()
                .filter(a -> a % 2 != 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getevenHouses() {
        return streetOfHouses.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
    }


}
