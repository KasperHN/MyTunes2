
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import be.SongModel;
import bll.SongBLL;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URL;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ResourceBundle;



/**
 * FXML Controller class
 *
 * @author chri9
 */
public class FXMLController implements Initializable {
private SongBLL sb;
   

@FXML
private TableView<SongModel> SongList;
@FXML
private TableColumn<SongModel, String> C1;
@FXML
private TableColumn<SongModel, String> C2;
@FXML
private TableColumn<SongModel, String> C3;
    
    
/**
* Initializes the controller class.
* @param url
* @param rb
*/
@Override
public void initialize(URL url, ResourceBundle rb) {
    try
    {
    sb = SongBLL.getInstance();
          
    } catch (Exception ex)
    {
    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
      
        
    SongList.setItems((ObservableList<SongModel>) sb.getAllSongs());
    C1.setCellValueFactory(new PropertyValueFactory("title"));
    C2.setCellValueFactory(new PropertyValueFactory("artist"));
    C3.setCellValueFactory(new PropertyValueFactory("genre"));
    sb.loadSongs();
    }    
    
}
