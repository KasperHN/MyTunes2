/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author chri9
 */
public class MyTunesPlay {
private MediaPlayer myTunesPlay;



    

    
  
    
    public static void main(String[] args)
    {
    
        MyTunesPlay myTunesPlay = new MyTunesPlay();
        myTunesPlay.playMyTunes();
    
    }
    
   
//   public void playMyTunes() 
//   { 
//   String bip = "C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3";
//   Media hit = new Media(bip);
//   myTunesPlay = new MediaPlayer(hit);
//   myTunesPlay.play();
//   }


    
   
    public void playMyTunes()
    { 
//        File file = new File("/Users/kaspe/Documents/GitHub/MyTunes2/MyTunes1/music/Castille_Soap.mp3");
//        String bip;
//        bip = file.toURI().toString();
//        File bip = new File("C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3");
        Media hit = new Media("C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3");
        myTunesPlay = new MediaPlayer(hit);
        myTunesPlay.play();
       System.out.println(hit);
        
    }

    
}



