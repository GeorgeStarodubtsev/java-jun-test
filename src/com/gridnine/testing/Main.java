package com.gridnine.testing;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        FlightProcessorMeth excludePastArrival = FlightProcessorMeth.EPA;
        FlightProcessorMeth excludeDepBeforeArr = FlightProcessorMeth.EDBA;
        FlightProcessorMeth excludeMoreThenTHG = FlightProcessorMeth.EMTT;



        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> fli = flights.stream()
                .filter(flight -> {return FlightProcessor.flightProcessor(flight,excludePastArrival); })
                .collect(Collectors.toList());
        System.out.println(flights.size());
        System.out.println(fli.size());



        System.out.println("---------excludePastArrival---------");
        FlightListProcessor.processorFlightList(flights, excludePastArrival);

        System.out.println("--------- excludeDepBeforeArr ---------");
        FlightListProcessor.processorFlightList(flights, excludeDepBeforeArr);

        System.out.println("-------- excludeMoreThenTwoHoursGround ----------");
        FlightListProcessor.processorFlightList(flights, excludeMoreThenTHG);

        System.out.println("------------------");

        System.out.println("--------- test variable-length arguments method---------");
        System.out.println("--------- with all methods ---------");
        FlightListProcessor.processorFlightList(flights, excludeDepBeforeArr, excludePastArrival, excludeMoreThenTHG);

    }
}
