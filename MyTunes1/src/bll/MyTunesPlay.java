/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

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
   public void playMyTunes() 
   { 
   String bip = "C:/Users/chri9/OneDrive/Dokumenter/NetBeansProjects/MyTunes2/MyTunes1/Music/Castille_Soap.mp3";
   Media hit = new Media(bip);
   myTunesPlay = new MediaPlayer(hit);
   myTunesPlay.play();
   }
    
}
