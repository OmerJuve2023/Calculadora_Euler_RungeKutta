package metodo_runge_kutta;

import Colores.KL;
import Colores.Operates;
import datos.Dao;
import datos.dates;

import java.text.DecimalFormat;


public class methods_runge_kutta extends Dao {

    public dates runge = new dates();
    public double[] y;
    public double[] x;
    final Operates c = new Operates();

    @Override
    public void ingress() {
        InsertRequest(runge);
    }

    private String format(String funcion, double x, double y) {
        DecimalFormat format = new DecimalFormat("###0.0#####");
        return funcion.replace("x", c.purple("(") + format.format(x) +
                                    c.purple(")")).replace("y", c.purple("(") +
                                                                format.format(y) + c.purple(")"));
    }

    @Override
    public void ejection_y() {
        y = new double[runge.getN()];
        y[0] = runge.getY1();
        for (int i = 1; i < runge.getN(); i++) {
            double k1 = function(runge.getFunction(), x[i - 1], y[i - 1]);
            double k2 = function(runge.getFunction(), x[i - 1] + runge.getH() / 2, y[i - 1] + (runge.getH() / 2) * k1);
            double k3 = function(runge.getFunction(), x[i - 1] + runge.getH() / 2, y[i - 1] + (runge.getH() / 2) * k2);
            double k4 = function(runge.getFunction(), x[i - 1] + runge.getH(), y[i - 1] + (runge.getH() * k3));
            y[i] = y[i - 1] + (runge.getH() / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        }
    }

    public void printFunction(double h, String fa, double x1, double y1, double N, double[] x) {

        double[] y = new double[(int) N + 1];
        x[0] = x1;
        y[0] = y1;
        DecimalFormat f = new DecimalFormat("####.######");
        c.println(c.purple("-------------------------------------------------------------------"));
        for (int i = 1; i < N; i++) {
            c.println(c.red("n =") + c.green("" + i) + "\t" + c.red("x" + (i) + " =") +
                      c.green("" + f.format(x[i])));

            double k1 = function(runge.getFunction(), x[i - 1], y[i - 1]);
            c.println(c.blue(KL.K1.getkL()) + c.red("=") + format(fa, x[i - 1], y[i - 1]) +
                      "\t" + c.blue(KL.K1.getkL()) + c.red("=") + c.green(f.format(k1)));
            double k2 = function(runge.getFunction(), x[i - 1] + h / 2, y[i - 1] + (h / 2) * k1);
            c.println(c.blue(KL.K2.getkL()) + c.red("=") + format(fa, x[i - 1] + h / 2, y[i - 1] +
                                                                                        (h / 2) * k1) + "\t" + c.blue(KL.K2.getkL()) + c.red("=") + c.green(f.format(k2)));
            double k3 = function(runge.getFunction(), x[i - 1] + h / 2, y[i - 1] + (h / 2) * k2);
            c.println(c.blue(KL.K3.getkL()) + c.red("=") + format(fa, x[i - 1] + h / 2, y[i - 1] +
                                                                                        (h / 2) * k2) + "\t" + c.blue(KL.K3.getkL()) + c.red("=") + c.green(f.format(k3)));
            double k4 = function(runge.getFunction(), x[i - 1] + h, y[i - 1] + (h * k3));
            c.println(c.blue(KL.K4.getkL()) + c.red("=") + format(fa, x[i - 1] + h, y[i - 1] +
                                                                                    (h * k3)) + "\t" + c.blue(KL.K4.getkL()) + c.red("=") + c.green(f.format(k4)));
            y[i] = y[i - 1] + (runge.getH() / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            c.println(c.blue("y" + (i + 1)) + c.red("=") + c.green(f.format(y[i])));
            c.println(c.purple("--------------------------------------------------------------"));
        }
    }
}