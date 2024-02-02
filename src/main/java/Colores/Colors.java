package Colores;

public enum Colors {

    BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, RESET;

    public String getColors() {
        return switch (this) {
            case BLACK -> " \033[30m ";
            case RED -> " \033[31m ";
            case GREEN -> " \033[32m ";
            case YELLOW -> " \033[33m ";
            case BLUE -> " \033[34m ";
            case PURPLE -> " \033[35m ";
            case CYAN -> " \033[36m ";
            case WHITE -> " \033[37m ";
            case RESET -> " \033[0m ";
            default -> null;
        };
    }

}
