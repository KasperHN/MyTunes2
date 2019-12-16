/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class MusicPlayer
{
    public final static int NOTSTARTED = 0;
    public final static int PLAYING = 1; 
    public final static int PAUSED = 2;
    public final static int FINISHED = 3;

    public MusicPlayer() {
        
        
        
    }
    
        
    public static int getNOTSTARTED() {
        return NOTSTARTED;
    }

    public static int getPLAYING() {
        return PLAYING;
    }

    public static int getPAUSED() {
        return PAUSED;
    }

    public static int getFINISHED() {
        return FINISHED;
    }   
}
