package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightListProcessor {

    private final FlightProcessor flightProcessor = new FlightProcessor();

    //List Rule arguments method
    public List<Flight> processFlightList(List<Flight> flights, List<FilterRule> rules) {

        if (rules.isEmpty() || rules.contains(null)) {
            throw new IllegalArgumentException();
        }
        if (rules.size() == 1) {
            return filterByRule(flights, rules.get(0));
        }
        List<Flight> result = new ArrayList<>(flights);
        for (int i = 0; i < rules.size(); i++) {
            result = filterByRule(result, rules.get(i));
        }
        return result;
    }

    public void printFlightList(List<Flight> flights) {
        flights.forEach(flight -> System.out.println(flight.toString()));
    }

    private List<Flight> filterByRule(List<Flight> flights, FilterRule rule) {

        if (rule.equals(FilterRule.EXCLUDE_NOTHING)) {
            return flights;
        }
        List<Flight> result = new ArrayList<>();
        if (rule.equals(FilterRule.EXCLUDE_DEP_BEFORE_ARR)) {
            return flights.stream().filter(flight -> flightProcessor.excludeDepBeforeArr(flight)).collect(Collectors.toList());
        }
        if (rule.equals(FilterRule.EXCLUDE_PAST_ARRIVAL)) {
            return flights.stream().filter(flight -> flightProcessor.excludePastArrival(flight)).collect(Collectors.toList());
        }
        if (rule.equals(FilterRule.EXCLUDE_MORE_THEN_THG)) {
            return flights.stream().filter(flight -> flightProcessor.excludeMoreThenTHG(flight)).collect(Collectors.toList());
        }
        throw new UnsupportedOperationException("Unsupported filtering rule");
    }


}
