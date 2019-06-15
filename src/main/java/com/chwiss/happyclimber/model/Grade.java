package com.chwiss.happyclimber.model;


public enum Grade {
    FIVECP("5C+"),
    SIXA("6A"),
    SIXAP("6A+"),
    SIXB("6B"),
    SIXBP("6B+"),
    SIXC("6C"),
    SIXCP("6C+"),
    SEVENA("7A"),
    SEVENAP("7A+"),
    SEVENB("7B"),
    SEVENBP("7B+"),
    SEVENC("7C"),
    SEVENCP("7C+"),
    EIGHTA("8A"),
    EIGHTAP("8A+"),
    EIGHTB("8B"),
    EIGHTBP("8B+"),
    EIGHTC("8C"),
    EIGHTCP("8C+"),
    NINEA("9A"),
    NINEAP("9A+"),
    NINEB("9B"),
    NINEBP("9B+"),
    NINEC("9C");

    private String label;

    Grade(String val) {
        this.label = val ;
    }

    public String getLabel() {
        return label;
    }

}
    //String enumValue = Enum.GetName(typeof(Grade), Grade._6A);

    // sixa = "6a";
    // sixaplus = "6a+";
    // sixb = "6b";
