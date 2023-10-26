package ba.unsa.etf.rpr.predavanje02;

public class Racunanje {
    public class Fje{
        public static double sinus(double number) {
            return Math.sin(number);
        }

        public static long faktorijel(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is undefined for negative numbers");
            }
            if (n == 0) {
                return 1;
            }
            long faktorijel = 1;
            for (int i = 1; i <= n; i++) {
                faktorijel *= i;
            }
            return faktorijel;
        }
    }
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        double rez = Fje.sinus(n);
        System.out.println("Sinus(" + n + ") = " + rez);
        int intN = (int) n;
        long rezz = Fje.faktorijel(intN);
        System.out.println("Faktorijel(" + intN + ") = " + rezz);
    }
}
