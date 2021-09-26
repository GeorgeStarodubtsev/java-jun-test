package com.gridnine.testing;

import java.util.List;

public abstract class FlightListProcessor {

    //variable-length arguments method
    public static void processorFlightList(List<Flight> flights, FlightProcessorMeth... method) {
        //EPA("excludePastArrival"),
        //EDBA("excludeDepBeforeArr"),
        //EMTT("excludeMoreThenTHG");

        boolean printFlight;

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            printFlight = true;

            for (FlightProcessorMeth meth : method) {
                switch (meth) {
                    case EPA:
                        printFlight = FlightProcessor.excludePastArrival(flight);
                        break;
                    case EDBA:
                        printFlight = printFlight & FlightProcessor.excludeDepBeforeArr(flight);
                        break;
                    case EMTT:
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

}
