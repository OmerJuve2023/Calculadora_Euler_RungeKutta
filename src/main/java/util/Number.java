package util;

public enum Number {

    k1("K" + "\u2081"),
    k2("K" + "\u2082"),
    k3("K" + "\u2083"),
    k4("K" + "\u2084"),
    l1("L" + "\u2081"),
    l2("L" + "\u2082"),
    l3("L" + "\u2083"),
    l4("L" + "\u2084");

    private final String message;

    private Number(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}