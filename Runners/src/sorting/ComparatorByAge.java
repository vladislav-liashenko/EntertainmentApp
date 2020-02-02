package sorting;

import model.Runner;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Runner> {

    public int compare(Runner a, Runner b) {
        int result =0;

            if (a.getAge() > b.getAge()) {
                result = 1;
            }
            if (a.getAge() < b.getAge()) {
                result = -1;
            }
            if (a.getAge() == b.getAge()) {
                result = 0;
            }
        return result;

    }
}