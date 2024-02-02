package datos;

import org.math.plot.Plot2DPanel;
import org.nfunk.jep.JEP;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Dao implements esqueleto {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void salida(double[] x, double[] y, int N) {
        DecimalFormat format = new DecimalFormat("##00.######");
        DecimalFormat form = new DecimalFormat("#0.00");
        System.out.println("interactions" + "\t" + "\t" + "X" + "\t" + "\t" + "\t" + "y");
        for (int i = 0; i < N; i++) {
            System.out.println("\t" + (i + 1) + "\t" + "|\t" + "\t" + form.format(x[i]) +
                    "\t" + "|\t" + format.format(y[i]));
        }
    }

    @Override
    public void grafica(String name, double[] x, double[] y) {

        JFrame panel = new JFrame("grafica");
        panel.setBounds(370, 10, 400, 350);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setResizable(false);
        Plot2DPanel grafica = new Plot2DPanel();
        grafica.setBounds(370, 10, 400, 350);
        grafica.addLegend("SOUTH");
        grafica.removeAllPlots();
        grafica.addLinePlot(name, x, y);
        grafica.setVisible(true);
        panel.add(grafica);

    }

    @Override
    public double funcion(String number, double x, double y) {
        JEP jep = new JEP();
        jep.addStandardConstants();
        jep.addStandardFunctions();
        jep.addVariable("x", x);
        jep.addVariable("y", y);
        jep.parseExpression(number);
        return jep.getValue();
    }

    @Override
    public double decimal(String name) {
        System.out.print(name);
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String text(String name) {
        System.out.print(name);
        return scanner.next();
    }

    @Override
    public void ingreso() {

    }

    @Override
    public double[] ejecucion_x(double initial, int N, double h) {
        double[] x = new double[N];
        x[0] = initial;
        for (int i = 1; i < N; i++) {
            x[i] = x[i - 1] + h;
        }
        return x;
    }

    @Override
    public void ejecucion_y() {

    }
}
