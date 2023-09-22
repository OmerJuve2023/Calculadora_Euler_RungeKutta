package ejecutable;

import metodo_euler.metodo_euler;
import metodo_runge_kutta.metodo_runge_kutta;
import pdf.desarrollo;
import pdf.union;

import javax.swing.*;
import java.util.Scanner;

public class ejecutable {

    static Scanner scanner = new Scanner(System.in);
    private final union union = new union();
    private final desarrollo des = new desarrollo();

    public void euler() {
        des.estilo();
        metodo_euler eu = new metodo_euler();
        eu.ingreso();
        eu.x = eu.ejecucion_x(eu.euler.getX1(), eu.euler.getN(), eu.euler.getH());
        eu.ejecucion_y();
        eu.salidita(eu.euler.getH(), eu.euler.getFuncion(), eu.euler.getX1(), eu.euler.getY1(), eu.euler.getN(), eu.x);
        //eu.salida(eu.x, eu.y, eu.euler.getN());
        //eu.grafica(eu.euler.getFuncion(), eu.x, eu.y);
        //union.init(eu.x, eu.y);
        //pregunta(); //
    }

    public void runge() {
        des.estilo();
        metodo_runge_kutta run = new metodo_runge_kutta();
        run.ingreso();
        run.x = run.ejecucion_x(run.runge.getX1(), run.runge.getN(), run.runge.getH());
        run.ejecucion_y();
        //run.salidita(run.runge.getH(), run.runge.getFuncion(), run.runge.getX1(), run.runge.getY1(), run.runge.getN(), run.x);
        //run.salida(run.x, run.y, run.runge.getN());
        //run.grafica(run.runge.getFuncion(), run.x, run.y);
        union.init(run.x, run.y);
        pregunta();
    }

    public void pregunta() {
        System.out.println("Desea continuar: si(s) / no(n)");
        if (scanner.next().equals("s")) {
            menu();
        } else {
            System.exit(0);
        }
    }

    public void menu() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
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