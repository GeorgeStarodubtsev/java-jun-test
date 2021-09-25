package com.gridnine.testing;

import java.util.List;

public abstract class FlightListProcessing {

    //variable-length arguments method
    public static void processingFlightList(List<Flight> flights, FlightProcessingMeth... method){
        //EPA("excludePastArrival"),
        //EDBA("excludeDepBeforeArr"),
        //EMTT("excludeMoreThenTHG");

        boolean useEPA = false;
        boolean useEDBA= false;
        boolean useEMTT = false;
        boolean printFlight;

        for (FlightProcessingMeth met:method) {
            switch (met){
                case EPA:
                    useEPA = true;
                    break;
                case EDBA:
                    useEDBA = true;
                    break;
                case EMTT:
                    useEMTT = true;
                    break;
                default:
                    break;
            }
        }

        for (Flight flight : flights) {

            printFlight = true;

            if(useEPA)
                printFlight = FlightProcessing.excludePastArrival(flight);

            if(useEDBA)
                    printFlight = printFlight & FlightProcessing.excludeDepBeforeArr(flight);

            if(useEMTT)
                printFlight = printFlight & FlightProcessing.excludeMoreThenTHG(flight);

            if(printFlight)
                System.out.println(flight.toString());

        }
    }
}
