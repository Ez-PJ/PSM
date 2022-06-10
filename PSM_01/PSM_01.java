package psm;

import java.util.Scanner;

public class PSM_01 {

    public static void main(String[] args) {
        //countForOne();
        countFromTo();
    }

    /**
     * counts taylor series for provided x value and n derivatives
     * works for floating point as x value
     */
    public static void countForOne() {
        Scanner sc = new Scanner(System.in);

        System.out.print("value of x = ");
        double xVal = sc.nextDouble();

        System.out.print("number of derivatives = ");
        int numberOfDerivatives = sc.nextInt();

        System.out.println();

        if (numberOfDerivatives <= 10) {
            System.out.println("sin(" + xVal + "):");
            taylorSeries(xVal, numberOfDerivatives);
            System.out.println();
        }
        else
            System.err.println("limit of derivatives per X is 10. Don't eat whole RAM :P");
    }

    /**
     * counts taylor series for provided compartment [xmin ; xmax] and n derivatives
     * works for integers as x value only due to iteration stuff
     */
    public static void countFromTo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("min x = ");
        int xMin = sc.nextInt();

        System.out.print("max x = ");
        int xMax = sc.nextInt();

        System.out.print("number of derivatives = ");
        int numberOfDerivatives = sc.nextInt();

        System.out.println();

        if (numberOfDerivatives <= 10) {
            if (xMin <= xMax) {
                for (int i = xMin; i <= xMax; i++) {
                    System.out.println("sin(" + i + "):");
                    taylorSeries(i, numberOfDerivatives);
                    System.out.println();
                }
            }
            else
                System.err.println("max value cannot be lesser than minimal one!");
        }
        else
            System.err.println("limit of derivatives per X is 10. Don't eat whole RAM :P");
    }

    /**
     *
     * @param xValue              x value of the sine function
     * @param numberOfDerivatives maximum number of derivatives for sin(x) function
     */
    public static void taylorSeries(double xValue, int numberOfDerivatives) {
        double sum = 0;
        double derivative;

        for (int i = 0; i < numberOfDerivatives; i++) {
            derivative = calculateDerivative(xValue, i);
            sum += derivative;
            System.out.println(derivative);
        }
        System.out.println("sum = " + sum);
    }

    /**
     * formula for sin(x): [(-1)^n / (2n+1)!] * x^(2n+1)
     *
     * @param x value of sine function, which will be proceeded
     * @param n serial number of derivative
     * @return  nth derivative of sin(x) function
     */
    public static double calculateDerivative(double x, int n) {
        if (n >= 0)
            return Math.pow(-1, n) / calculateFactorial(2 * n + 1) * Math.pow(x, 2 * n + 1);
        else
            return 0;
    }

    /**
     *
     * @param inputNumber the number whose factorial will be returned as result
     * @return            factorial of the number given as the method parameter
     */
    public static int calculateFactorial(int inputNumber) {
        if (inputNumber < 1)
            return 1;
        else
            return inputNumber * calculateFactorial(inputNumber - 1);
    }

}