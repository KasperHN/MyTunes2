/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import be.MusicPlayer;
import be.SongModel;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.toIntExact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.print.attribute.standard.Media;
import javax.swing.text.html.HTML.Tag;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;



/**
 * FXML Controller klasse
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public abstract class Import_mp3Controller implements Initializable 
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
    
    @FXML
    private void editSong(ActionEvent event) throws IOException 
    {
        
    }
    
    void refreshSongList(boolean isEditing) 
    {
       
        
    }
    
    void setInfo(SongModel selectedItem) 
    {
        
        
    }

    @FXML
    private void addSong(ActionEvent event, int i) 
    {
        
    }
    
     @FXML
    public void chooseFile(ActionEvent event)
    {

        try
        {
            FileChooser fileChooser = new FileChooser();
            Window stage = null;
            File file = fileChooser.showOpenDialog(stage);

            AudioFile f;
            f = AudioFileIO.read(file);
            Tag t = f.getTagOrCreateAndSetDefault();
            time.setText(Integer.toString(f.getAudioHeader().getTrackLength()));
            artistField.setText(t.getFirst(FieldKey.ARTIST));
            title.setText(t.getFirst(FieldKey.TITLE));
            file.setText(file.getPath());
            f.commit();

        } catch (Exception e)
        {
        }
    }
    @FXML
    private void newCancelButton(ActionEvent event)
    {
        
        Stage stage = (Stage)  btnCancel.getScene().getWindow();
        stage.close();
    }
}

