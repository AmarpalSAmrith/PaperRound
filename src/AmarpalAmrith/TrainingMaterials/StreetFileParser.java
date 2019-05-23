package AmarpalAmrith.TrainingMaterials;

import java.util.*;
import java.util.stream.Collectors;

public class StreetFileParser {

    public static Street getStreet(String file) {
        List<Integer> houses = convertFile(file.trim());

        if (!isValidFile(houses)) {
            throw new IllegalArgumentException("This is not a valid file of house numbers");
        }
        return new Street(houses, getOddHouses(houses), getEvenHouses(houses));
    }

    private static List<Integer> convertFile(String file) throws IllegalArgumentException {
        String[] splitString = file.split(" ");
        List<String> list = Arrays.asList(splitString);
        List<Integer> numberList = new ArrayList<>();

        if (!isIntegers(list)) {
            throw new IllegalArgumentException("not a list of numbers!");
        }


        for (String s : list) {
            numberList.add(Integer.valueOf(s));
        }

        return numberList;
    }

    private static List<Integer> getOddHouses(List<Integer> list) {
        return list.stream()
                .filter(a -> a % 2 != 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> getEvenHouses(List<Integer> list) {
        return list.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
    }

    private static boolean isValidFile(List<Integer> list) {
        List<Integer> oddHouses = list.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
        List<Integer> evenHouses = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        if (!startsAt1(list)) {
            System.out.println("not 1");
            return false;
        }

        if (!evenStartsAt2(evenHouses)) {
            System.out.println("even numbers doesn't start at 2");
            return false;
        }

        if (!isSequential(evenHouses) || !isSequential(oddHouses)) {
            System.out.println("not sequential");
            return false;
        }
        if (isDuplicates(list)) {
            System.out.println("found duplicates");
            return false;
        }

        return true;
    }

    private static boolean startsAt1(List<Integer> list) {
        return list.get(0) == 1;
    }

    private static boolean evenStartsAt2(List<Integer> list) {
        if (list.size() > 0) {
            return list.get(0) == 2;
        } else {
            return true;
        }
    }

    private static boolean isSequential(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) != list.get(i - 1) + 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    private static boolean isIntegers(List<String> list) {
        for (String s : list) {
            try {
                Integer.valueOf(s);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


}
