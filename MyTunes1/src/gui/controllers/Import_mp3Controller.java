/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import be.MusicPlayer;
import be.SongModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TextField artistField;
    @FXML
    private TextField time;
    @FXML
    private TextField categoryChoice;
    @FXML
    private TextField file;
    @FXML
    private Button btnCancel;
    @FXML
    private Label errorLabel;

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
    private void addSong(ActionEvent event, int i) 
    {
//        int i = toIntExact(Math.round(MusicPlayer.getMusic().getDuration().toSeconds())); 
//        String name = nameField.getText().trim();
        if (title != null && title.getlength() > 0 && title.length() < 50 && urlField.getText() != null && urlField.getText().length() != 0 && i > 0) 
        { 
            if (!isEditing) 
            { 
                SongModel.createSong(title, artistField.getText(), categoryChoice.getSelectionModel().getSelectedItem(), i, urlField.getText());
                errorLabel.setText("Success: Successfully created the song");
            } else 
            {
                SongModel.updateSong(songToEdit, title, artistField.getText(), categoryChoice.getSelectionModel().getSelectedItem(), i, urlField.getText());
                errorLabel.setText("Success: Successfully updated the song");
            }
        } else 
        {
            errorLabel.setText("Error: Check if you have inserted a name and selected the correct file");
        }

        controller1.refreshSongList(isEditing); 
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

