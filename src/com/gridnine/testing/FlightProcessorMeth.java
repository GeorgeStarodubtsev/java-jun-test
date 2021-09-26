package com.gridnine.testing;

public enum FlightProcessorMeth {
    ENOTHING("excludeNothing"),
    EPA("excludePastArrival"),
    EDBA("excludeDepBeforeArr"),
    EMTT("excludeMoreThenTHG");

    private final String methName;
    FlightProcessorMeth(String methName){
        this.methName = methName;
    }
    public String getMethName(){
        return getMethName();
    }
}
