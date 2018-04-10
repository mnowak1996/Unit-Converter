import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class UnitConverter {

    ObservableList<String> conversions = FXCollections.observableArrayList("Centymetry na cale", "Cale na centymetry");
    // lista dni tygodnia typu Observable list

    @FXML
    private ComboBox comboBox;
    @FXML
    private TextArea pole;
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
    @FXML
    private void Convert(){
        String value = String.valueOf(comboBox.getValue());
        pole.setText(value+"2");
    }

}
