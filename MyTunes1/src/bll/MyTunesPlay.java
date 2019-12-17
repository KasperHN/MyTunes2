/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


/**
 *
 * @author chri9
 */
public class MyTunesPlay extends Application {
    
    
//private MediaPlayer TunesPlay;
//
//
//
//    
//   
//    public void start(Stage primaryStage) {
//
//        playMyTunes();
//        TunesPlay = new MyTunesPlay();
//
//        // Add a mediaView, to display the media. Its necessary !
//        // This mediaView is added to a Pane
//        
//        MediaView mediaView = new MediaView(TunesPlay);
//        // Add to scene
//        Group root = new Group(mediaView);
//        Scene scene = new Scene(root, 500, 200);
//
//        // Show the stage
//        primaryStage.setTitle("Media Player");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        }
    @Override
    public void start(Stage primaryStage) {

        Media pick = new Media("Users/kaspe/Documents/GitHub/MyTunes2/MyTunes1/music/Lulu_Is_the_Cat_I_Like_Best.mp3"); // replace this with your own audio file
        MediaPlayer player = new MediaPlayer(pick);

        // Add a mediaView, to display the media. Its necessary !
        // This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);

        // Add to scene
        Group root = new Group(mediaView);
        Scene scene = new Scene(root, 500, 200);

        // Show the stage
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Play the media once the stage is shown
        player.play();
    }
    
  
    
    public static void main(String[] args)
    {
    
        launch(args);
        
    
    }
    
   
//   public void playMyTunes() 
//   { 
//   String bip = "C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3";
//   Media hit = new Media(bip);
//   myTunesPlay = new MediaPlayer(hit);
//   myTunesPlay.play();
//   }


    
//   
//    public void playMyTunes()
//    { 
//       File file = new File("/Users/kaspe/Documents/GitHub/MyTunes2/MyTunes1/music/Castille_Soap.mp3");        String bip;        bip = file.toURI().toString();
//       File bip = new File("C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3");
//        Media hit = new Media("/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3");
//        myTunesPlay = new MediaPlayer(hit);
//        myTunesPlay.play();
//       System.out.println(hit);
//        
//    }

    
}



