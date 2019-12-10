/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author chri9
 */
public class Import_mp3Controller implements Initializable 
{

    @FXML
    private TextField title;
    @FXML
    private Button btnMore;
    @FXML
    private Button btnChoose;
    @FXML
    private Button btnSave;
    @FXML
    private TextField artist;
    @FXML
    private TextField time;
    @FXML
    private TextField category;
    @FXML
    private TextField file;
    @FXML
    private Button btnCancel;


    //cancel application
//    private void CancelApplication(); 
//    {
//        System.exit(0);
//    } 
//
//
//    //save and open file
//    private void OpenAndFindFile(java.awt.event.ActionEvent evt) 
//    {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Specify a file to save");
// 
//        int OpenAndFindFile = fileChooser.showSaveDialog(parentFrame);
// 
//        if (SaveFile == JFileChooser.APPROVE_OPTION) 
//        {
//        File fileToSave = fileChooser.getSelectedFile();
//        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//        }
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }

    
    

    @FXML
    private void addSong(ActionEvent event) 
    {
        
    }
    
    @FXML
    private void moreCat(ActionEvent event) 
    {
        
    }
    
    @FXML
    private void chooseSong(ActionEvent event) 
    {
        
    }
    
    @FXML
    private void addCancel(ActionEvent event) 
    {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}

