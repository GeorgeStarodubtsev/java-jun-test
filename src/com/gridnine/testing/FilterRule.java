package com.gridnine.testing;

public enum FilterRule {
    EXCLUDE_NOTHING("excludeNothing"),
    EXCLUDE_PAST_ARRIVAL("excludePastArrival"),
    EXCLUDE_DEP_BEFORE_ARR("excludeDepBeforeArr"),
    EXCLUDE_MORE_THEN_THG("excludeMoreThenTHG");

    private final String methName;
    FilterRule(String methName){
        this.methName = methName;
    }
    public String getMethName(){
        return getMethName();
    }
}
