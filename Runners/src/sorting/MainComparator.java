package sorting;

import model.Runner;

import java.util.Comparator;
import java.util.function.Function;

public class MainComparator implements Comparator<Runner> {
    ComparatorByAge comparatorAge=new ComparatorByAge();
    ComparatorByProfit comparatorProf=new ComparatorByProfit();
    @Override
    public int compare(Runner a, Runner b) {
        int result = NullComparator.checkNull(a,b);
        if (result == NullComparator.NOT_NULL) {
            if(result!=0)
            result = a.getFullName().compareTo(b.getFullName());
            if (result == 0) {
                result = comparatorProf.compare(a, b);
            }if (result == 0) {
                result = comparatorAge.compare(a, b);
            }
        }
        return result;
    }



}