import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DecimalFormat;

/**
 * Created by Michał Nowak
 */
public class UnitConverter {

    ObservableList<String> conversions = FXCollections.observableArrayList("Centymetry na cale",
            "Cale na centymetry","Metry na centymetry","Centymetry na metry","Litry na mililitry","Mililitry na litry","Litry na m3");
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
        comboBox.getEditor().setFont(Font.font(30));

    }
    private double cal=2.54;
    private double wynik;
    private double centymetry;
    private double metry;
    private double litry;
    private double mililitry;

    @FXML
    private void Convert(){
        try {
            Fonts();
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
                case "Litry na mililitry":
                    litry = Double.parseDouble(ReplaceComma(pole.getText()));
                    wynik = litry*1000;
                    label.setText("litrów to " + wynik + " mililitrów");
                    break;
                case "Mililitry na litry":
                    mililitry = Double.parseDouble(ReplaceComma(pole.getText()));
                    wynik = mililitry/1000;
                    label.setText("mililitrów to " + wynik + " litrów");
                    break;
                case "Litry na m3":
                    litry = Double.parseDouble(ReplaceComma(pole.getText()));
                    wynik = litry/1000;
                    label.setText("litrów to " + wynik + " m3");
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
    private void Fonts(){
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font(18));
    }

}
