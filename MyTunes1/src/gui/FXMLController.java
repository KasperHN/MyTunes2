
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
        String bip = "file:/C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3";
        Media hit = new Media(bip);
        mediaPlay = new MediaPlayer(hit);
        mediaPlay.play();
    }  
   
        
//    SongList.setItems((ObservableList<SongModel>) sb.getAllSongs());
//    C1.setCellValueFactory(new PropertyValueFactory("title"));
//    C2.setCellValueFactory(new PropertyValueFactory("artist"));
//    C3.setCellValueFactory(new PropertyValueFactory("genre"));
//    sb.loadSongs();
    }    

 
    

