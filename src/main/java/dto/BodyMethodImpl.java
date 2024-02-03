package dto;

import entity.Data;
import util.Operates;
import org.math.plot.Plot2DPanel;
import org.nfunk.jep.JEP;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BodyMethodImpl implements BodyMethod {
    final Scanner scanner = new Scanner(System.in);
    final Operates o = new Operates();

    @Override
    public void goOut(double[] x, double[] y, int N) {
        DecimalFormat format = new DecimalFormat("##00.######");
        DecimalFormat form = new DecimalFormat("#0.00");
        o.println("interactions" + "\t" + "\t" + "X" + "\t" + "\t" + "\t" + "y");
        for (int i = 0; i < N; i++) {
            o.println("\t" + (i + 1) + "\t" + "|\t" + "\t" + form.format(x[i]) +
                      "\t" + "|\t" + format.format(y[i]));
        }
    }

    @Override
    public void graffiti(String name, double[] x, double[] y) {

        JFrame panel = new JFrame("graph of the function");
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
    public double function(String number, double x, double y) {
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
        o.print(name);
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String text(String name) {
        o.print(name);
        return scanner.next();
    }

    @Override
    public void ingress() {

    }

    @Override
    public double[] ejection_x(double initial, int N, double h) {
        double[] x = new double[N];
        x[0] = initial;
        for (int i = 1; i < N; i++) {
            x[i] = x[i - 1] + h;
        }
        return x;
    }

    @Override
    public void ejection_y() {

    }

    public void InsertRequest(Data data) {
        double r_final = decimal("range final:");
        data.setH(decimal("INGRESS h: "));
        data.setX1(decimal("INGRESS x1: "));
        data.setY1(decimal("INGRESS y1: "));
        data.setFunction(text("INGRESS FUNCTION: F(X,Y)="));
        data.setN((int) Math.round(((r_final - data.getX1()) / data.getH()) + 1));
    }
}
