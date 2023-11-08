package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
    


 
public final class MonthSorterNested implements MonthSorter {


    private static final Comparator<String> BY_DAYS = new SortByDays();
    private static final Comparator<String> BY_ORDER = new SortByMonthOrder();

    @Override
    public Comparator<String> sortByDays() {
        return BY_DAYS;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return BY_ORDER;
    }

    private enum Month{
        JANUARY(30),
        FEBRARY(28),
        MARCH(31),
        APRIL(31),
        MAY(30),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);


        private final int days;

        Month(final int days){
            this.days=days;
        }
      
        public static Month fromString(final String name){
            for(Month m:Month.values()){
                if(m.name().equalsIgnoreCase(name) || m.name().startsWith(name.toUpperCase())){
                    return m;
                }
            }
        throw new  IllegalArgumentException("Invalid month: " + name);

            }
        }
    private static class SortByMonthOrder implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
           return Month.fromString(o1).compareTo(Month.fromString(o2));
        }
        
    }
    private static class SortByDays implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            var m1 = Month.fromString(o1);
            var m2 = Month.fromString(o2);
            return Integer.compare(m1.days, m2.days);
          
        }

    }



    }

    

