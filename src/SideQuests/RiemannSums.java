package SideQuests;

public class RiemannSums {
    public static void main(String[] args) {
        int n = 4;
        int b = 9;
        int a = 1;

        int x = (b - a) / n;
        double[] points = {1.1, 1.3, 1.7, 2.4, 3.3};

        System.out.println("Left: " + leftRule(x, points));
        System.out.println("Right: " + rightRule(x, points));
        System.out.println("Trapezoid: " + trapezoidRule(x, points));
        System.out.println("Simpson: " + simpsonRule(x, points));
    }

    public static double leftRule(int x, double[] points) {
        double ySum = 0.0;

        for (int i = 0; i < points.length - 1; i++) {
            ySum += points[i];
        }

        return ySum * x;
    }

    public static double rightRule(int x, double[] points) {
        double ySum = 0.0;

        for (int i = 1; i < points.length; i++) {
            ySum += points[i];
        }

        return ySum * x;
    }

    public static double trapezoidRule(int x, double[] points) {
        double ySum = points[0] + points[points.length - 1];

        for (int i = 1; i < points.length - 1; i++) {
            ySum += (2 * points[i]);
        }

        return ySum * x / 2;
    }

    public static double simpsonRule(int x, double[] points) {
        double ySum = points[0] + points[points.length - 1];

        for (int i = 1; i < points.length - 1; i++) {
            if (i % 2 == 0) {
                ySum += (2 * points[i]);
            } else {
                ySum += (4 * points[i]);
            }
        }

        return ySum * x / 3;
    }
}
