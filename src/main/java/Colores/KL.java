package Colores;

public enum KL {
    K1, K2, K3, K4, l1, l2, l3, l4;

    public String getkL() {
        switch (this) {
            case K1:
                return "K" + "\u2081";
            case K2:
                return "K" + "\u2082";
            case K3:
                return "K" + "\u2083";
            case K4:
                return "K" + "\u2084";
            case l1:
                return "L" + "\u2081";
            case l2:
                return "L" + "\u2082";
            case l3:
                return "L" + "\u2083";
            case l4:
                return "L" + "\u2084";
            default:
                return null;
        }
    }
}
