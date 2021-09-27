package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightProcessor {

    public boolean excludePastArrival(Flight flight) {
        // исправить, возможно в задании имелось ввиду проверить каждый сегмент
        for(int i = 0; i < flight.getSegments().size(); i++) {
            if(LocalDateTime.now().isAfter(flight.getSegments().get(i).getDepartureDate()))
                return false;
        }
        return true;
    }

    public boolean excludeDepBeforeArr(Flight flight) {
        for (Segment seg: flight.getSegments()) {
            if(seg.getDepartureDate().isBefore(seg.getArrivalDate()))
                return true;
        }
            return false;
    }

    public boolean excludeMoreThenTHG(Flight flight) {
        Duration groundTime = Duration.ofSeconds(0);

        for(int i = 0; i < flight.getSegments().size() - 1; i++){
            groundTime = groundTime.plus(Duration.between(flight.getSegments().get(i).getArrivalDate(),
                    flight.getSegments().get(i + 1).getDepartureDate()));

            if(groundTime.compareTo(Duration.ofSeconds(7200)) > -1){
                return false;
            }
        }
        return true;
    }
}
