package com.medassi.bdpm_ui_grb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author amedassi
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField tfMot;
    @FXML
    private ListView<Medicament> lvMedocs;
    @FXML
    private Label labelDenomination;
    @FXML
    private Label labelDateAMM;
    @FXML
    private Label labelTitulaires;
    @FXML
    private ListView<Composant> lvComposants;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void onNewWord(KeyEvent event) {
        String mot = tfMot.getText() ;
        if( mot.length() >= 3 ){
            ObservableList<Medicament> lesMedocs = BDPM.getDatabase().getMedicamentsByMotClef(mot) ;
            lvMedocs.setItems(lesMedocs);
        }
        
    }

    @FXML
    private void onClicListMedocs(MouseEvent event) {
        Medicament medocSel = lvMedocs.getSelectionModel().getSelectedItem() ;
        labelDenomination.setText(medocSel.denomination);
        labelDateAMM.setText(medocSel.date_amm);
        labelTitulaires.setText(medocSel.titulaires);
    }
    
}
