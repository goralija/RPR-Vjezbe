package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.beans.property.SimpleStringProperty;

public class Controller {
    public Label display;
    public StringBuilder operandi = new StringBuilder("");
    private String trenutniUnos = "0";

    @FXML
    private SimpleStringProperty unos = new SimpleStringProperty("");

    @FXML
    public void initialize() {
        unos.set("0");
        display.textProperty().bind(unos);
    }

    private void appendToUnos(String value) {
        if (trenutniUnos.equals("0")) {
            if (!value.equals(".")) {
                operandi.append(value);
                trenutniUnos = value;
                unos.set(trenutniUnos);
            }
        } else {
            if (!value.equals(".") || !trenutniUnos.contains(".")) {
                trenutniUnos += value;
                operandi.append(value);
                unos.set(trenutniUnos);
            }
        }
    }

    @FXML
    void jednakoClick() {
        try {
            String rezultat = CalculationSetup.izracunaj(operandi.toString());
            StringBuilder rezkonacni = new StringBuilder(rezultat);
            if (rezkonacni.toString().matches("-?\\d+")) {
                rezkonacni.append(".0");
            }
            unos.set(String.valueOf(rezkonacni));
            operandi.setLength(0);
            operandi.append(unos.get());
            trenutniUnos = unos.get();
        } catch (Exception e) {
            unos.set("Greška");
        }
    }

    @FXML
    void saberiClick() {
        operandi.append("+");
        trenutniUnos = "0";
        unos.set(trenutniUnos);
    }

    @FXML
    void oduzmiClick() {
        operandi.append("-");
        trenutniUnos = "0";
        unos.set(trenutniUnos);
    }

    @FXML
    void pomnoziClick() {
        operandi.append("*");
        trenutniUnos = "0";
        unos.set(trenutniUnos);
    }

    @FXML
    void podijeliClick() {
        operandi.append("/");
        trenutniUnos = "0";
        unos.set(trenutniUnos);
    }

    @FXML
    void procenatClick() {
        operandi.append("%");
        trenutniUnos = "0";
        unos.set(trenutniUnos);
    }

    @FXML
    void btn0() {
        appendToUnos("0");
    }

    @FXML
    void btn1() {
        appendToUnos("1");
    }

    @FXML
    void btn2() {
        appendToUnos("2");
    }

    @FXML
    void btn3() {
        appendToUnos("3");
    }

    @FXML
    void btn4() {
        appendToUnos("4");
    }

    @FXML
    void btn5() {
        appendToUnos("5");
    }

    @FXML
    void btn6() {
        appendToUnos("6");
    }

    @FXML
    void btn7() {
        appendToUnos("7");
    }

    @FXML
    void btn8() {
        appendToUnos("8");
    }

    @FXML
    void btn9() {
        appendToUnos("9");
    }

    @FXML
    void dotBtn() {
        appendToUnos(".");
    }
}

