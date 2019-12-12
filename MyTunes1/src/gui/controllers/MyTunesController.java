/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;
import be.MusicPlayer;
import static be.MusicPlayer.NOTSTARTED;
import static be.MusicPlayer.FINISHED;
import static be.MusicPlayer.PAUSED;
import static be.MusicPlayer.PLAYING;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;

/**
 * FXML kontrol klasse
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class MyTunesController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btnPlay;
    @FXML
    private TextArea SongName;
    @FXML
    private ListView<?> Playlist;
    @FXML
    private ListView<?> Favorites;
    @FXML
    private ListView<?> Search;   
    @FXML
    private Button btnStop;
    @FXML
    private Button btnPause;
    @FXML
    private Button addSong;
    
    private MusicPlayer musicPlayer;
    
    public int playerStatus;
    
            
    /**
     * Starter kontrol klasse
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {      
    
    }    

    @FXML
    private void play() throws JavaLayerException 
    {
        playSong();
    }
    
    private void stop() throws JavaLayerException 
    {
        stopSong();
    }
    
    private void pause() throws JavaLayerException 
    {
            if (playerStatus == PLAYING) 
            {
                pauseSong();
            }
            else
            {
                resumeSong();    
            }
    }
    
    @FXML
    private void playSong() throws JavaLayerException 
    {
        musicPlayer.play();
    }

    @FXML
    private void stopSong() 
    {
        musicPlayer.stop();
    }

    @FXML
    private void pauseSong() 
    {
        musicPlayer.pause();
    }

    @FXML
    private void resumeSong() 
    {
        musicPlayer.resume();
    }
    

    @FXML
    private void addSong(ActionEvent event) 
    {
        openAddSong();
    }

    private void openAddSong()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("import_mp3.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("addSong");
            stage.setScene(new Scene(root1));  
            stage.show();
            }
        catch(Exception e) 
            {
                e.printStackTrace();
            }
    }
}
