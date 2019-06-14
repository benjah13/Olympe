package fr.thales.solradapter.model;

public enum ResponseKeyWord {

    HOWMANY("@HOWMANY@"),
    WHO("@WHO@");

    private String value;

    ResponseKeyWord(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
