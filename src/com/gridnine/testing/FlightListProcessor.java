package com.gridnine.testing;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightListProcessor {

//    public List<Flight> flightFilteredList(List<Flight> flights, Set<FilterRule> methods){
//        Set<FilterRule> met = methods;
//        return flights.stream()
//                .filter(flight -> {return FlightProcessor.flightFilter(flight, met ); })
//                .collect(Collectors.toList());
//    }

    //variable-length arguments method
    public static void printListWithFilter(List<Flight> flights, FilterRule... method) {
        //EPA("excludePastArrival"),
        //EDBA("excludeDepBeforeArr"),
        //EMTT("excludeMoreThenTHG");

        boolean printFlight;

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            printFlight = true;

            for (FilterRule meth : method) {
                switch (meth) {
                    case EXCLUDE_PAST_ARRIVAL:
                        printFlight = FlightProcessor.excludePastArrival(flight);
                        break;
                    case EXCLUDE_DEP_BEFORE_ARR:
                        printFlight = printFlight & FlightProcessor.excludeDepBeforeArr(flight);
                        break;
                    case EXCLUDE_MORE_THEN_THG:
                        printFlight = printFlight & FlightProcessor.excludeMoreThenTHG(flight);
                        break;
                    default:
                        break;
                }
            }

            if (printFlight) {
                System.out.println(flight.toString());
            } else {
                System.out.print("Delete Flight: ");
                System.out.println(flight.toString());
            }
        }
    }

    //private FlightProcessor flightProcessor = new FlightProcessor();

}
