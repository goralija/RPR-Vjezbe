package ba.unsa.etf.rpr.lv7z11;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    public ListView ListViewId;
    public TextField ImeId;
    public TextField PrezimeId;
    public TextField EmailId;
    public TextField UsernameId;
    public PasswordField PasswordId;
    public Button DodajButtonId;
    public Button KrajButtonId;
    public KorisniciModel model;

    public void krajClick() {
        Platform.exit();
    }

    public void dodajClick() {
        model.dodaj();
        ListViewId.getSelectionModel().selectLast();
    }

    @FXML
    public void initialize() {
        model = new KorisniciModel();
        ListViewId.setItems(model.getKorisnici());
        ListViewId.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik((Korisnik)newKorisnik);
            ListViewId.refresh();

            if(oldKorisnik != null) {
                ImeId.textProperty().unbindBidirectional(((Korisnik)oldKorisnik).imeProperty());
                PrezimeId.textProperty().unbindBidirectional(((Korisnik)oldKorisnik).prezimeProperty());
                EmailId.textProperty().unbindBidirectional(((Korisnik)oldKorisnik).emailProperty());
                UsernameId.textProperty().unbindBidirectional(((Korisnik)oldKorisnik).usernameProperty());
                PasswordId.textProperty().unbindBidirectional(((Korisnik)oldKorisnik).passwordProperty());
            }

            if(newKorisnik == null) {
                ImeId.setText("");
                PrezimeId.setText("");
                EmailId.setText("");
                UsernameId.setText("");
                PasswordId.setText("");
            }
            else {
                ImeId.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                PrezimeId.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
                EmailId.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
                UsernameId.textProperty().bindBidirectional(model.getTrenutniKorisnik().usernameProperty());
                PasswordId.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
            }

        });
        /*
        ImeId.getStyleClass().add("poljeNijeIspravno");
        ImeId.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldIme, String newIme) {
                if(ImeId.getText().trim().isEmpty() || !ImeId.getText().matches("[a-zA-Z]+")) {
                    ImeId.getStyleClass().removeAll("poljeJeIspravno");
                    ImeId.getStyleClass().add("poljeNijeIspravno");
                }
                else {
                    ImeId.getStyleClass().removeAll("poljeNijeIspravno");
                    ImeId.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
         */
    }

}