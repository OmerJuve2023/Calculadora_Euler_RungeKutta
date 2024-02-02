package metodo_euler;

import Colores.Operates;
import datos.Dao;
import datos.dates;

import java.text.DecimalFormat;

public class methods_euler extends Dao {

    public double[] x;
    public double[] y;
    public dates euler = new dates();
    Operates c = new Operates();

    @Override
    public void ingreso() {
        double r_final = decimal("rango final:");
        euler.setH(decimal("INGRESE h: "));
        euler.setX1(decimal("INGRESE x1: "));
        euler.setY1(decimal("INGRESE y1: "));
        euler.setFunction(text("INGRECE FUNCION: F(X,Y)="));
        euler.setN((int) Math.round(((r_final - euler.getX1()) / euler.getH()) + 1));
    }

    private String format(String function, double x, double y) {
        DecimalFormat format = new DecimalFormat("###0.0#####");
        return function.replace("x", c.purple("(") +
                                     format.format(x) + c.purple(")"))
                .replace("y", c.purple("(") + format.format(y) + c.purple(")"));
    }

    @Override
    public void ejecucion_y() {
        y = new double[euler.getN()];
        y[0] = euler.getY1();
        for (int i = 1; i < euler.getN(); i++) {
            y[i] = y[i - 1] + (euler.getH() * (funcion(euler.getFunction(), x[i - 1], y[i - 1])));
        }
    }

    public void salidita(double h, String fa, double x1, double y1, double N, double[] x) {

        double[] y = new double[(int) N + 1];
        x[0] = x1;
        y[0] = y1;
        DecimalFormat f = new DecimalFormat("####.######");

        for (int i = 1; i < N; i++) {

            int yn = i + 1;
            double ys = y[i - 1];
            double xs = x[i - 1];
            System.out.println(c.red("n =") + c.green("" + i) + "\t" + c.red("x" + (i) + " =") + c.green(f.format(x[i])));
            y[i] = y[i - 1] + (euler.getH() * (funcion(euler.getFunction(), xs, ys)));
            System.out.println(c.blue("y" + yn) + c.red("= ") + f.format(ys) + c.red("+") + h + c.yellow("(") + format(fa, xs, ys) + c.yellow(")"));
            System.out.println(c.blue("y" + yn) + c.red("= ") + f.format(ys) + c.red("+") + h + c.purple("(") + f.format(funcion(fa, Double.parseDouble(f.format(xs)), Double.parseDouble(f.format(ys)))) + c.purple(")"));
            System.out.println(c.blue("y" + yn) + c.red("= ") + c.green(f.format(y[i])));
            System.out.println(c.cyan("------------------------------------------------------------------------------"));
        }
    }
}