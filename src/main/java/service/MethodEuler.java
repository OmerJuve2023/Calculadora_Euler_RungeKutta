package service;

import util.Operates;
import dto.BodyMethodImpl;
import entity.Data;

import java.text.DecimalFormat;

public class MethodEuler extends BodyMethodImpl {

    public double[] x;
    public double[] y;
    public final Data euler = new Data();
    final Operates c = new Operates();

    @Override
    public void ingress() {
        InsertRequest(euler);
    }

    private String format(String function, double x, double y) {
        final DecimalFormat format = new DecimalFormat("###0.0#####");
        return function.replace("x", c.purple("(") +
                                     format.format(x) + c.purple(")"))
                .replace("y", c.purple("(") + format.format(y) + c.purple(")"));
    }

    @Override
    public void ejection_y() {
        y = new double[euler.getN()];
        y[0] = euler.getY1();
        for (int i = 1; i < euler.getN(); i++) {
            y[i] = y[i - 1] + (euler.getH() * (function(euler.getFunction(), x[i - 1], y[i - 1])));
        }
    }

    public void printFunction(double h, String fa, double x1, double y1, double N, double[] x) {
        double[] y = new double[(int) N + 1];
        x[0] = x1;
        y[0] = y1;
        final DecimalFormat f = new DecimalFormat("####.######");

        for (int i = 1; i < N; i++) {
            int yn = i + 1;
            double ys = y[i - 1];
            double xs = x[i - 1];
            c.println(c.red("n =") + c.green("" + i) + "\t" + c.red("x" + (i) + " =") + c.green(f.format(x[i])));
            y[i] = y[i - 1] + (euler.getH() * (function(euler.getFunction(), xs, ys)));
            c.println(c.blue("y" + yn) + c.red("= ") + f.format(ys) + c.red("+") + h + c.yellow("(") + format(fa, xs, ys) + c.yellow(")"));
            c.println(c.blue("y" + yn) + c.red("= ") + f.format(ys) + c.red("+") + h + c.purple("(") + f.format(function(fa, Double.parseDouble(f.format(xs)), Double.parseDouble(f.format(ys)))) + c.purple(")"));
            c.println(c.blue("y" + yn) + c.red("= ") + c.green(f.format(y[i])));
            c.println(c.cyan("------------------------------------------------------------------------------"));
        }
    }
}