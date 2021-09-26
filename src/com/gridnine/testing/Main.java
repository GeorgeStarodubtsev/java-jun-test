package com.gridnine.testing;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FilterRule excludePastArrival = FilterRule.EXCLUDE_PAST_ARRIVAL;
        FilterRule excludeDepBeforeArr = FilterRule.EXCLUDE_DEP_BEFORE_ARR;
        FilterRule excludeMoreThenTHG = FilterRule.EXCLUDE_MORE_THEN_THG;
        Set<FilterRule> filterSetMeth = EnumSet.of(FilterRule.EXCLUDE_NOTHING,
                        FilterRule.EXCLUDE_MORE_THEN_THG);


        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> fli = flights.stream()
                .filter(flight -> {return FlightProcessor.flightFilter(flight,excludePastArrival); })
                .collect(Collectors.toList());
        System.out.println(flights.size());
        System.out.println(fli.size());



        System.out.println("---------excludePastArrival---------");
        FlightListProcessor.printListWithFilter(flights, excludePastArrival);

        System.out.println("--------- excludeDepBeforeArr ---------");
        FlightListProcessor.printListWithFilter(flights, excludeDepBeforeArr);

        System.out.println("-------- excludeMoreThenTwoHoursGround ----------");
        FlightListProcessor.printListWithFilter(flights, excludeMoreThenTHG);

        System.out.println("------------------");

        System.out.println("--------- test variable-length arguments method---------");
        System.out.println("--------- with all methods ---------");
        FlightListProcessor.printListWithFilter(flights, excludeDepBeforeArr, excludePastArrival, excludeMoreThenTHG);

    }
}
