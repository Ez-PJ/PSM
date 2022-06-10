package psm;

import java.util.ArrayList;
import java.util.List;

public class PSM_03 {

    private static float a = (float) Math.toRadians(45);
    private static float r = 1;
    private static float dt = 0.005f;
    private static float g = -10;
    private static float m = 1;
    private static float w = 0;

    private static List<Float> xList = new ArrayList<>();
    private static List<Float> yList = new ArrayList<>();
    private static List<Float> epList = new ArrayList<>(); // potential energy
    private static List<Float> ekList = new ArrayList<>(); // kinetic energy
    private static List<Float> etList = new ArrayList<>(); // total energy

    public static void main(String[] args) {
        //midpoint(100); // improved euler method
        rk4(100); // runge-kutta method
    }

    /**
     * this method solves equations using improved euler (mid-point) method
     */
    public static void midpoint(int iterations) {
        System.out.println("midpoint method" + "\n");

        for (int i = 0; i < iterations; i++) {

            // set values according to formulas
            float e = (g / r) * (float) Math.sin(a);

            float x = r * (float) Math.sin(a);
            xList.add(x);

            float y = r * (float) Math.cos(a);
            yList.add(y);

            float ep = m * g * (y + r); // (y + r) = h
            epList.add(ep);

            float ek = m * (float) Math.pow((r * w), 2) / 2;
            ekList.add(ek);

            float et = ep + ek;
            etList.add(et);

            // mid-point method implementation
            float w_2  = w + e * dt / 2;
            float a_2 = a + w * dt / 2;
            float e_2 = g / r * (float) Math.sin(a_2);

            float da = w_2 * dt;
            float dw = e_2 * dt;

            a += da;
            w += dw;
        }

        showData();
    }

    /**
     * this method solves equations using runge-kutta (rk4) method
     */
    public static void rk4(int iterations) {
        System.out.println("RK4 method" + "\n");

        for (int i = 0; i < iterations; i++) {

            // set values according to formulas
            float e = (g / r) * (float) Math.sin(a);

            float x = r * (float) Math.sin(a);
            xList.add(x);

            float y = r * (float) Math.cos(a);
            yList.add(y);

            float ep = m * g * (y + r); // (y + r) = h
            epList.add(ep);

            float ek = m * (float) Math.pow((r * w), 2) / 2;
            ekList.add(ek);

            float et = ep + ek;
            etList.add(et);

            // rk4 method implementation
            float k1a = w;
            float k1w = e;
            float k2a = calculateKna(k1w);
            float k2w = calculateKnw(k1a);
            float k3a = calculateKna(k2w);
            float k3w = calculateKnw(k2a);
            float k4a = calculateKnw(k3w);
            float k4w = calculateKnw(k3a);

            float da = ((k1a + 2 * k2a + 2 * k3a + k4a) / 6) * dt;
            float dw = ((k1w + 2 * k2w + 2 * k3w + k4w) / 6) * dt;

            a += da;
            w += dw;
        }

        showData();
    }

    /**
     * this is helper method, which calculates "knw" value
     *
     * @param kna previous kna: [k(n-1)a]
     * @return returns "knw" value based on provided "k(n-1)a" value
     */
    private static float calculateKnw(float kna) {
        return g / r * (float) Math.sin(a + kna * dt / 2);
    }

    /**
     * this is helper method, which calculates "kna" value
     *
     * @param knw previous knw: [k(n-1)w]
     * @return returns "kna" value based on provided "k(n-1)w" value
     */
    private static float calculateKna(float knw) {
        return w + knw * dt / 2;
    }

    /**
     * this method shows all data stored inside lists
     */
    public static void showData() {
        System.out.println("=== x values ===");
        xList.forEach(e -> System.out.println(e.toString().replaceAll("[.]", ",")));
        System.out.println();

        System.out.println("=== y values ===");
        xList.forEach(e -> System.out.println(e.toString().replaceAll("[.]", ",")));
        System.out.println();

        System.out.println("=== ek values ===");
        xList.forEach(e -> System.out.println(e.toString().replaceAll("[.]", ",")));
        System.out.println();

        System.out.println("=== ep values ===");
        xList.forEach(e -> System.out.println(e.toString().replaceAll("[.]", ",")));
        System.out.println();

        System.out.println("=== et values ===");
        xList.forEach(e -> System.out.println(e.toString().replaceAll("[.]", ",")));
        System.out.println();
    }

}