package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FlightProcessorTest {

    @Before
    public void setUp() throws Exception{
        List<Flight> flights = FlightBuilder.createFlights();
    }

    @Test
    public void excludePastArrival() {
        // создаем тестовые данные Flight c
        // временем вылета до текущего времени
        // LocalDateTime.now().isAfter(flight.getSegments().get(0).getDepartureDate()

        // expected = excludePastArrival(Flight)

        // actual = false;

        // Запускаем тест, в случае  если expected и actual не будут равны
        // тест будет провален
        // Assert.assertEquals(expected, actual);



    }

    @Test
    public void excludeDepBeforeArr() {

        // создаем тестовые данные Flight c
        // временем вылета после времени прилета
        // seg.getDepartureDate().isBefore(seg.getArrivalDate())

        // expected = excludePastArrival(Flight)

        // actual = false;

        // Запускаем тест, в случае  если expected и actual не будут равны
        // тест будет провален
        // Assert.assertEquals(expected, actual);
    }

    @Test
    public void excludeMoreThenTHG() {

        // создаем тестовые данные Flight c
        // временем на земле, большем чем 2 часа
        // groundTime = groundTime.plus(Duration.between(flight.getSegments().get(i).getArrivalDate(),
        //     flight.getSegments().get(i + 1).getDepartureDate()))

        // expected = excludePastArrival(Flight)

        // actual = false;

        // Запускаем тест, в случае  если expected и actual не будут равны
        // тест будет провален
        // Assert.assertEquals(expected, actual);

    }
}