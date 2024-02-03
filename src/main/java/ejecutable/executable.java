package ejecutable;

import metodo_euler.methods_euler;
import metodo_runge_kutta.methods_runge_kutta;
import pdf.desarrollo;
import pdf.union;

import javax.swing.*;
import java.util.Scanner;

public class executable {

    static Scanner scanner = new Scanner(System.in);
    private final union union = new union();
    private final desarrollo des = new desarrollo();

    public void euler() {
        des.estilo();
        methods_euler eu = new methods_euler();
        eu.ingress();
        eu.x = eu.ejection_x(eu.euler.getX1(), eu.euler.getN(), eu.euler.getH());
        eu.ejection_y();
        eu.printFunction(eu.euler.getH(), eu.euler.getFunction(), eu.euler.getX1(), eu.euler.getY1(), eu.euler.getN(), eu.x);
        eu.goOut(eu.x, eu.y, eu.euler.getN());
        eu.graffiti(eu.euler.getFunction(), eu.x, eu.y);
        union.init(eu.x, eu.y);
        question();
    }

    public void runge() {
        des.estilo();
        methods_runge_kutta run = new methods_runge_kutta();
        run.ingress();
        run.x = run.ejection_x(run.runge.getX1(), run.runge.getN(), run.runge.getH());
        run.ejection_y();
        run.printFunction(run.runge.getH(), run.runge.getFunction(), run.runge.getX1(), run.runge.getY1(), run.runge.getN(), run.x);
        run.goOut(run.x, run.y, run.runge.getN());
        run.graffiti(run.runge.getFunction(), run.x, run.y);
        union.init(run.x, run.y);
        question();
    }

    private void question() {
        System.out.println("Desea continuar: si(s) / no(n)");
        if (scanner.next().equals("s") || scanner.next().equals("si")) {
            menu();
        } else {
            System.exit(0);
        }
    }

    public void menu() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException e) {
            e.printStackTrace();
        }
        int n = 0;
        do {
            System.out.println("INGRESE QUE METODO SE USARA: EULER (E) RUNGE KUTTA(R)");
            String peticion = scanner.next();
            if (peticion.equalsIgnoreCase("e")) {
                euler();
            } else if (peticion.equalsIgnoreCase("r")) {
                runge();
            } else {
                n = 1;
                System.out.println("Debe poner uno de los caracteres correspondientes");
            }
        } while (n != 0);
    }

}