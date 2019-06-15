package com.chwiss.happyclimber.model;

public enum Ascent {

    ON("Onsight"),
    FL("Flash"),
    RP("Redpoint"),
    PP("Pinkpoint"),
    TR("Toprope"),
    FS("Freesolo");

    private String label;

    Ascent(String val) {
        this.label = val ;
    }

    public String getLabel() {
        return label;
    }
    }
