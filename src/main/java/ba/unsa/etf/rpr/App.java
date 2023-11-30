package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Primjeri korištenja klasa
        Student student = new Student("John", "Doe", "2", "123456");
        Nastavnik nastavnik = new Nastavnik("Prof", "X", "PhD");
        Predmet predmet = new Predmet("Java Programming", "Introduction to Java programming language");

        // Zadatak 2
        PredmetSaOcjenama predmetSaOcjenama = new PredmetSaOcjenama("Matematika", "Osnove matematike");
        NastavnikSaOcjenama nastavnikSaOcenama = new NastavnikSaOcjenama("Profesor", "Y", "PhD");

        // Ocjenjivanje predmeta
        Ocjena ocjenaZaPredmet = predmetSaOcjenama.ocijeni(9, new Student("Amar", "Hodzic","2","18352"));
        System.out.println("Ocjena za predmet " + predmetSaOcjenama.getNaziv() + ": " + ocjenaZaPredmet.getOcjena());

        // Ocjenjivanje nastavnika
        Ocjena ocjenaZaNastavnika = nastavnikSaOcenama.ocijeni(8, new Nastavnik("Belmin", "Durmo", "dr"));
        System.out.println("Ocjena za nastavnika " + nastavnikSaOcenama.getIme() + " " +
                nastavnikSaOcenama.getPrezime() + ": " + ocjenaZaNastavnika.getOcjena());
    }
}
