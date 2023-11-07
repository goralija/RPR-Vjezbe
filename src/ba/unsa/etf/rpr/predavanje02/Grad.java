package ba.unsa.etf.rpr.predavanje02;

public enum Grad {
        TRAVNIK("030"),
        ODZAK("031"),
        ZENICA("032"),
        SARAJEVO("033"),
        KUPRES("034"),
        TUZLA("035"),
        MOSTAR("036"),
        BIHAC("037"),
        GORAZDE("038"),
        LJUBUSKI("039"),
        BRCKO("049"),
        MRKONJIC("050"),
        BANJALUKA("051"),
        PRIJEDOR("052"),
        DOBOJ("053"),
        SAMAC("054"),
        BIJELJINA("055"),
        ZVORNIK("056"),
        PALE("057"),
        FOCA("058"),
        TREBINJE("059");
    private String pozivniBroj;

    Grad (String pozivniBroj) {this.pozivniBroj = pozivniBroj;}

    public static Grad izPozivnog (String pozivni) {
        for (Grad g:Grad.values()) {
            if (g.getPozivniBroj().equals(pozivni)) {
                return g;
            }
        }
        return null;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }
}
