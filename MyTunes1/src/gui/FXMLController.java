
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import be.Song;
import bll.SongBLL;


import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



/**
 * FXML Controller class
 *
 * @author chri9
 */
public class FXMLController implements Initializable {

   

private MediaPlayer mediaPlay;
    
    
    @FXML
    private TableColumn<Song, String> C1;
    @FXML
    private TableView<Song> songlist;

    
/**
* Initializes the controller class.
* @param url
* @param rb
*/
    private SongBLL sb;
    @FXML
    private Button knapsåmeget1;
    @FXML
    private Button knapsåmeget2;
    @FXML
    private Button knapsåmeget3;
    @FXML
    private Button knapsåmeget4;

    @Override
public void initialize(URL url, ResourceBundle rb) {
  // songlist.setItems(sb.getAllSongs());
    C1.setCellValueFactory(new PropertyValueFactory("title"));
//    C2.setCellValueFactory(new PropertyValueFactory("artist"));
//    C3.setCellValueFactory(new PropertyValueFactory("genre"));
//   sb.loadSongs();
}
    @FXML
    public void Knap(ActionEvent event)   
    {
        String bip = "file:/C:/Users/kaspe/Documents/GitHub/MyTunes2/MyTunes1/music/Lulu_Is_the_Cat_I_Like_Best.mp3";
        Media hit = new Media(bip);
        mediaPlay = new MediaPlayer(hit);
        mediaPlay.play();
    }  
   
    public void Pause(ActionEvent event) {
        mediaPlay.pause();
    }

    public void Stop(ActionEvent event) {
        mediaPlay.stop();
    }
    public void Skip(ActionEvent event) {
        
    }
    
    public void Previous(ActionEvent event) {
        
    }




//    SongList.setItems((ObservableList<SongModel>) sb.getAllSongs());
//    C1.setCellValueFactory(new PropertyValueFactory("title"));
//    C2.setCellValueFactory(new PropertyValueFactory("artist"));
//    C3.setCellValueFactory(new PropertyValueFactory("genre"));
//    sb.loadSongs();
    }    

 
    

