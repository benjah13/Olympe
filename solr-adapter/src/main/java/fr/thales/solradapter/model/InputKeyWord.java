package fr.thales.solradapter.model;

public enum InputKeyWord {

    AND("@AND@", " AND "),
    OR("@OR@", " OR ");

    private String value;
    private String convertValue;

    InputKeyWord(String value, String convertValue) {
        this.value = value;
        this.convertValue = convertValue;
    }

    public String getValue() {
        return value;
    }

    public String getConvertValue() {
        return convertValue;
    }
}
