/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import dal.SongDAO;
import be.MusicPlayer;
import be.SongModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



/**
 * FXML Controller klasse
 *
 * @author Nicklas, Kasper, Christian og Jonas
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
    private TextField genreChoice;
    @FXML
    private TextField file;
    @FXML
    private Button btnCancel;
    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
    
    @FXML
    private void editSong(ActionEvent event) throws IOException {
        if (tableViewSongs.getSelectionModel().getSelectedIndex() != -1) {
            setUpScenes(2, true);
        }
    }
    
    void refreshSongList(boolean isEditing) 
    {
        allSongs.getItems().clear();
        tableViewSongs.setItems(SongModel.getSongs());
        if (isEditing) {
            songsInPlaylist.getItems().clear();
            refreshList();
        }
    }
    
    void setInfo(SongModel selectedItem) 
    {
        isEditing = true;
        songToEdit = selectedItem;
        title.setText(selectedItem.getTitle());
        if (selectedItem.getArtist() != null) {
            artistField.setText(selectedItem.getArtist());
        }
        title.setText(selectedItem.getSongLocation());
        if (selectedItem.getGenre() != null) {
            genreChoice.setValue(selectedItem.getGenre());
        } else {
            genreChoice.setValue("");
        }
        musicplayer = new MusicPlayer(new Media(new File(selectedItem.getLocation()).toURI().toString()));
        
    }

    @FXML
    private void addSong(ActionEvent event, int i) 
    {
       int i = toIntExact(Math.round(MusicPlayer.getMusic().getDuration().toSeconds())); 
        String title = titleField.getText().trim();
        if (title != null && title.getLength() > 0 && title.getLength() < 50 && title.getText() != null && title.getText().length() != 0 && i > 0) 
        { 
            if (!isEditing) 
            { 
                SongModel.createSong(title, artistField.getText(), genreChoice.getSelectionModel().getSelectedItem(), i, title.getText());
                errorLabel.setText("Success: Successfully created the song");
            } 
            else 
            {
                SongModel.updateSong(songToEdit, title, artistField.getText(), genreChoice.getSelectionModel().getSelectedItem(), i, title.getText());
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop")); //Sets the directory to the desktop
        fileChooser.setTitle("Select song");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) 
        {
            title.setText(selectedFile.getAbsolutePath());    
        }
    }
    
    @FXML
    private void addCancel(ActionEvent event) 
    {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}

