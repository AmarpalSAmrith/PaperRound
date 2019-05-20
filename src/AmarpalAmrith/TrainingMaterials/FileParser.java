package AmarpalAmrith.TrainingMaterials;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileParser {

    public static List<Integer> convertFile(String file) throws IllegalArgumentException {
        String[] splitString = file.split(" ");
        List<String> list = Arrays.asList(splitString);

        if (!isIntegers(list)) {
            throw new IllegalArgumentException("not a list of numbers!");
        }

        List<Integer> numberList = new ArrayList<>();

        for (String s : list) {
            numberList.add(Integer.valueOf(s));
        }

        return numberList;
    }

    public static boolean isValidFile(List<Integer> list) {
        List<Integer> oddHouses = list.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
        List<Integer> evenHouses = list.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());;

        if (!startsAt1(list)) {
            System.out.println("not 1");
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

    public static boolean startsAt1(List<Integer> list) {
        return list.get(0) == 1;
    }

    public static boolean isSequential(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) != list.get(i - 1) + 2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>(list);
        return set.size() < list.size();
    }

    public static boolean isIntegers(List<String> list) {
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
