package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightProcessingMeth excludePastArrival = FlightProcessingMeth.EPA;
        FlightProcessingMeth excludeDepBeforeArr = FlightProcessingMeth.EDBA;
        FlightProcessingMeth excludeMoreThenTHG = FlightProcessingMeth.EMTT;


        System.out.println("---------excludePastArrival---------");
        FlightListProcessing.processingFlightList(flights, excludePastArrival);

        System.out.println("--------- excludeDepBeforeArr ---------");
        FlightListProcessing.processingFlightList(flights, excludeDepBeforeArr);

        System.out.println("-------- excludeMoreThenTHG ----------");
        FlightListProcessing.processingFlightList(flights, excludeMoreThenTHG);

        System.out.println("------------------");

        System.out.println("--------- test variable-length arguments method---------");
        System.out.println("--------- with all methods ---------");
        FlightListProcessing.processingFlightList(flights, excludeDepBeforeArr, excludePastArrival, excludeMoreThenTHG);

    }
}
