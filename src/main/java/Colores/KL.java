package Colores;

public enum KL {
    K1, K2, K3, K4, l1, l2, l3, l4;

    public String getkL() {
        return switch (this) {
            case K1 -> "K" + "\u2081";
            case K2 -> "K" + "\u2082";
            case K3 -> "K" + "\u2083";
            case K4 -> "K" + "\u2084";
            case l1 -> "L" + "\u2081";
            case l2 -> "L" + "\u2082";
            case l3 -> "L" + "\u2083";
            case l4 -> "L" + "\u2084";
            default -> null;
        };
    }
}
