import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    @FXML
    private void Convert(){
        String value = String.valueOf(comboBox.getValue());
//        value = value.replaceAll(",",".");

        switch (value){
            case "Centymetry na cale":
                double centymetry =Double.parseDouble(ReplaceComma(pole.getText()));
                wynik=(centymetry/cal);
                label.setText("centymetrów to "+new DecimalFormat("##.##").format(wynik)+" cali");
                break;
            case "Cale na centymetry":
                double cale =Double.parseDouble(ReplaceComma(pole.getText()));
                double wynik=cale*cal;
                label.setText("cali to "+wynik+" centymetrów");
                break;
        }
    }

    private String ReplaceComma (String a){
        if(a.contains(",")) {
            a = a.replaceAll(",", ".");
        }
        return a;
    }

}
