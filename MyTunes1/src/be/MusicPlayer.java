/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;


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

    // Player bliver brugt af mange af de andre instanser
    public Player player;

    
    public Object playerLock = new Object();

    // Variable om hvilken af vores 4 statiske int. er i effekt.
    public int playerStatus = NOTSTARTED;

    
    public MusicPlayer(InputStream inputStream) throws JavaLayerException // referere til vores javalayerexception.java klasse
    {
        this.player = new Player(inputStream);
    }

    public MusicPlayer(InputStream inputStream, AudioDevice audioDevice) throws JavaLayerException 
    {
        this.player = new Player(inputStream, audioDevice);
    }

    
    /**
     * Afspil sang
     */
    public void play() throws JavaLayerException 
    {
        synchronized (playerLock) 
        {
            switch (playerStatus) 
            {
                case NOTSTARTED:
                    Runnable r = new Runnable() 
                    {
                        public void run() 
                        {
                            playInternal();
                        }
                    };
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Pause knap
     */
    public boolean pause() 
    {
        synchronized (playerLock) 
        {
            if (playerStatus == PLAYING) 
            {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumere sang
     */
    public boolean resume() 
    {
        synchronized (playerLock) 
        {
            if (playerStatus == PAUSED) 
            {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }

    /**
     * Afbryder sang
     */
    public void stop() 
    {
        synchronized (playerLock) 
        {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }

    private void playInternal() 
    {
        while (playerStatus != FINISHED) 
        {
            try 
            {
                if (!player.play(1)) {
                    break;
                }
            } 
            catch (final JavaLayerException e) 
            {
                break;
            }
            // Checker om pause eller lukket
            synchronized (playerLock) 
            {
                while (playerStatus == PAUSED) 
                {
                    try 
                    {
                        playerLock.wait();
                    }
                    catch (final InterruptedException e) 
                    {
                        // Afslutter afspiller
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Afslutter afspilleren
     */
    public void close() 
    {
        synchronized (playerLock) 
        {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) 
        {
        }
    }
