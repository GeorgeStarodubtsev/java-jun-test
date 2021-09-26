package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightProcessorMeth excludePastArrival = FlightProcessorMeth.EPA;
        FlightProcessorMeth excludeDepBeforeArr = FlightProcessorMeth.EDBA;
        FlightProcessorMeth excludeMoreThenTHG = FlightProcessorMeth.EMTT;


        System.out.println("---------excludePastArrival---------");
        FlightListProcessor.processorFlightList(flights, excludePastArrival);

        System.out.println("--------- excludeDepBeforeArr ---------");
        FlightListProcessor.processorFlightList(flights, excludeDepBeforeArr);

        System.out.println("-------- excludeMoreThenTHG ----------");
        FlightListProcessor.processorFlightList(flights, excludeMoreThenTHG);

        System.out.println("------------------");

        System.out.println("--------- test variable-length arguments method---------");
        System.out.println("--------- with all methods ---------");
        FlightListProcessor.processorFlightList(flights, excludeDepBeforeArr, excludePastArrival, excludeMoreThenTHG);

    }
}
