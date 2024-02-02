package Colores;

public class Operates {

    public String red(String txt){
        return Colors.RED.getColors() + txt + Colors.RESET.getColors();
    }
    public String green(String txt){
        return Colors.GREEN.getColors() + txt + Colors.RESET.getColors();
    }
    public String yellow(String txt){
        return Colors.YELLOW.getColors() + txt + Colors.RESET.getColors();
    }
    public String blue(String txt){
        return Colors.BLUE.getColors() + txt + Colors.RESET.getColors();
    }
    public String purple(String txt){
        return Colors.PURPLE.getColors() + txt + Colors.RESET.getColors();
    }
    public String cyan(String txt){
        return Colors.CYAN.getColors() + txt + Colors.RESET.getColors();
    }
}
