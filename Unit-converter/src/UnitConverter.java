import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.*;
import java.text.DecimalFormat;

public class UnitConverter {

    ObservableList<String> conversions = FXCollections.observableArrayList("Centymetry na cale",
            "Cale na centymetry","Metry na centymetry","Centymetry na metry");
    // lista dni tygodnia typu Observable list

    @FXML
    private ComboBox comboBox;
    @FXML
    private TextField pole;
    @FXML
    private Label label;

    /**
     * Metoda która zosyaje automatycznie wywołana przy starcie aplikacji
     * Ustawia ona dni tygodnia jako elementy ComboBoxa
     */
    @FXML
    private void initialize() {
        comboBox.setItems(conversions);
    }
    private double cal=2.54;
    private double wynik;
    private double centymetry;
    private double metry;

    @FXML
    private void Convert(){
        try {
            String value = String.valueOf(comboBox.getValue());
            switch (value) {
                case "Centymetry na cale":
                        centymetry = Double.parseDouble(ReplaceComma(pole.getText()));
                        wynik = (centymetry / cal);
                        label.setText("centymetrów to " + new DecimalFormat("##.##").format(wynik) + " cali");
                    break;
                case "Cale na centymetry":
                    double cale = Double.parseDouble(ReplaceComma(pole.getText()));
                    double wynik = cale * cal;
                    label.setText("cali to " + wynik + " centymetrów");
                    break;
                case "Metry na centymetry":
                    metry = Double.parseDouble(ReplaceComma(pole.getText()));
                    wynik = metry * 100;
                    label.setText("metrów to " + wynik + " centymetrów");
                    break;
                case "Centymetry na metry":
                    centymetry = Double.parseDouble(ReplaceComma(pole.getText()));
                    wynik = centymetry / 100;
                    label.setText("centymatrów to " + wynik + " metrów");
                    break;

            }
        }catch(Exception ex)
        {
            label.setTextFill(Color.RED);
            label.setFont(Font.font(25));
            label.setText("Podałeś złe dane");
        }
    }

    private String ReplaceComma (String a){
        if(a.contains(",")) {
            a = a.replaceAll(",", ".");
        }
        return a;
    }


}
