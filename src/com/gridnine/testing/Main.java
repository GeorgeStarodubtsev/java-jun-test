package com.gridnine.testing;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilterRule p = FilterRule.EXCLUDE_PAST_ARRIVAL;
        FilterRule d = FilterRule.EXCLUDE_DEP_BEFORE_ARR;
        FilterRule m = FilterRule.EXCLUDE_MORE_THEN_THG;
        FilterRule n = FilterRule.EXCLUDE_NOTHING;
        ArrayList<FilterRule> excludeAll = new ArrayList<>();
        excludeAll.add(p);
        excludeAll.add(d);
        excludeAll.add(m);
        excludeAll.add(n);
        ArrayList<FilterRule> ePastArrival = new ArrayList<>();
        ePastArrival.add(p);
        ArrayList<FilterRule> eDepBeforeArr = new ArrayList<>();
        eDepBeforeArr.add(d);
        ArrayList<FilterRule> eMoreThenTwoHoursGround = new ArrayList<>();
        eMoreThenTwoHoursGround.add(m);

        List<Flight> flights = FlightBuilder.createFlights();
        FlightListProcessor processor = new FlightListProcessor();

        System.out.println("---------- flights Exclude Past Arrival ----------");
        List<Flight> flightsExcludePastArrival = processor.
                processFlightList(flights, new ArrayList<FilterRule>(Collections.singletonList(FilterRule.EXCLUDE_PAST_ARRIVAL)));
        processor.printFlightList(flightsExcludePastArrival);

        System.out.println("---------- flights Exclude Departure Before Arrival ----------");
        List<Flight> flightsExcludeDepBeforeArr = processor.processFlightList(flights, eDepBeforeArr);
        processor.printFlightList(flightsExcludeDepBeforeArr);

        System.out.println("---------- flights Exclude More Then Two Hours Ground ----------");
        List<Flight> flightsExcludeMoreThenTwoHoursGround = processor.processFlightList(flights, eMoreThenTwoHoursGround);
        processor.printFlightList(flightsExcludeMoreThenTwoHoursGround);

//        System.out.println("---------- flights With All Rule ----------");
//        List<Flight> flightsWithAllRule = processor.processFlightList(flights, excludeAll);
//        processor.printFlightList(flightsWithAllRule);

    }
}
