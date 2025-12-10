/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.medassi.bdpm_ui_grb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextArea taFiche;
    @FXML
    private ListView<?> lvMedocs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onNewWord(KeyEvent event) {
    }

    @FXML
    private void onClicListMedocs(MouseEvent event) {
    }
    
}
