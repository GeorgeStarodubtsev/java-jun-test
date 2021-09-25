package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights.size());

        System.out.println("---------excludePastArrival---------");
        for (Flight flight : flights) {
            if (FlightProcessing.excludePastArrival(flight))
                System.out.println(flight.toString());

        }

        System.out.println("--------- excludeDepBeforeArr ---------");
        for (Flight flight : flights) {
            if (FlightProcessing.excludeDepBeforeArr(flight))
                System.out.println(flight.toString());

        }

        System.out.println("-------- excludeMoreThenTHG ----------");
        for (Flight flight : flights) {
            if (FlightProcessing.excludeMoreThenTHG(flight))
                System.out.println(flight.toString());

        }

        System.out.println("------------------");
        System.out.println("------------------");

    }
}
