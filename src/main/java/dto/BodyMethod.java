package dto;

public interface BodyMethod {
    void ingress();

    double[] ejection_x(double initial, int N, double h);

    void ejection_y();

    String text(String name);

    double function(String number, double x, double y);

    double decimal(String name);

    void goOut(double[] x, double[] y, int N);

    void graffiti(String name, double []x, double []y);
}
