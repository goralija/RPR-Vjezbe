package ba.unsa.etf.rpr.predavanje02;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    List<Double> lista = new ArrayList<Double>();
        Scanner ulaz = new Scanner(System.in);

        boolean a = true;
        while (a) {
            System.out.println("Unesite neki realan broj, ili stop za kraj (za sve drugo unos ce biti ponovljen): ");
            String red = ulaz.nextLine();
            if(red.equalsIgnoreCase("stop")) break;
            try {
                Double broj = Double.parseDouble(red);
                lista.add(broj);
            }
            catch (NumberFormatException e) {
                System.out.println("Unos ne sadrzi broj");
            }
        }

        if (lista.isEmpty()) {
            System.out.println("Niste unijeli niti jedan broj");
        }
        else {
            System.out.println("Najmanji clan liste je " + getMin(lista));
            System.out.println("Najveci clan liste je " + getMax(lista));
            System.out.println("Srednja vrijednost liste je " + getMean(lista));
            System.out.println("Standardna devijacija liste je " + getStandardDeviation(lista));
        }
    }

    public static Double getMin(List<Double> lista) {
        Double min = lista.get(0);
        for(Double x : lista) {
            if(x < min) {
                min = x;
            }
        }
        return min;
    }

    public static Double getMax(List<Double> lista) {
        Double max = lista.get(0);
        for(Double x : lista) {
            if(x > max) {
                max = x;
            }
        }
        return max;
    }

    public static Double getMean(List<Double> lista) {
        Double sum = (Double) 0.0;
        for(Double x : lista) {
            sum = sum + x;
        }
        return sum/lista.size();
    }

    public static Double getStandardDeviation(List<Double> lista) {
        Double mean = getMean(lista);
        Double sum = (Double) 0.0;
        for(Double x : lista) {
            sum = sum + java.lang.Math.pow((x-mean), 2);
        }
        sum = sum / (lista.size() - 1);
        return java.lang.Math.sqrt(sum);
    }
}
