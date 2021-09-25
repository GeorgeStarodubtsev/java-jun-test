package com.gridnine.testing;

public enum FlightProcessingMeth {
    ENOTHING("excludeNothing"),
    EPA("excludePastArrival"),
    EDBA("excludeDepBeforeArr"),
    EMTT("excludeMoreThenTHG");

    private final String methName;
    FlightProcessingMeth(String methName){
        this.methName = methName;
    }
    public String getMethName(){
        return getMethName();
    }
}
