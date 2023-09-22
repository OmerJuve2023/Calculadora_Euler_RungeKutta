package datos;

public interface esqueleto {
    void ingreso();

    double[] ejecucion_x(double inicial, int N, double h);

    void ejecucion_y();

    String text(String name);

    double funcion(String number, double x, double y);

    double decimal(String name);

    void salida(double[] x, double[] y, int N);

    void grafica(String name,double []x,double []y);
}
