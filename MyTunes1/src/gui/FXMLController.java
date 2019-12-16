
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import be.Song;
import bll.SongBLL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



/**
 * FXML Controller class
 *
 * @author chri9
 */
public class FXMLController implements Initializable {
private SongBLL sb;
   

private MediaPlayer mediaPlay;
    
    @FXML
    private Button knapsåmeget;
    @FXML
    private Button Stop;
    @FXML
    private Button Pause;
    @FXML
    private Button Previous;
    @FXML
    private Button Skip;
    
/**
* Initializes the controller class.
* @param url
* @param rb
*/
@Override
public void initialize(URL url, ResourceBundle rb) {
}
    @FXML
    public void Knap(ActionEvent event)   
    {
        String bip = "file:/C:/Users/kaspe/Documents/GitHub/MyTunes2/MyTunes1/music/Castille_Soap.mp3";
        Media hit = new Media(bip);
        mediaPlay = new MediaPlayer(hit);
        mediaPlay.play();
    }  
   
    @FXML
    public void Pause(ActionEvent event) {
        mediaPlay.pause();
    }

    @FXML
    public void Stop(ActionEvent event) {
        mediaPlay.stop();
    }
    @FXML
    public void Skip(ActionEvent event) {
        
    }
    
    @FXML
    public void Previous(ActionEvent event) {
        
    }




//    SongList.setItems((ObservableList<SongModel>) sb.getAllSongs());
//    C1.setCellValueFactory(new PropertyValueFactory("title"));
//    C2.setCellValueFactory(new PropertyValueFactory("artist"));
//    C3.setCellValueFactory(new PropertyValueFactory("genre"));
//    sb.loadSongs();
    }    

 
    

