package Colores;

public class Operadores {

    public String red(String txt){
        return Colores.RED.getColores() +txt+Colores.RESET.getColores();
    }
    public String green(String txt){
        return Colores.GREEN.getColores() +txt+Colores.RESET.getColores();
    }
    public String yellow(String txt){
        return Colores.YELLOW.getColores() +txt+Colores.RESET.getColores();
    }
    public String blue(String txt){
        return Colores.BLUE.getColores() +txt+Colores.RESET.getColores();
    }
    public String purple(String txt){
        return Colores.PURPLE.getColores() +txt+Colores.RESET.getColores();
    }
    public String cyan(String txt){
        return Colores.CYAN.getColores() +txt+Colores.RESET.getColores();
    }
}
