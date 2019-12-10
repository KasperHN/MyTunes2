/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.util.Scanner;



/**
 *
 * @author jonas
 */

public class SongDatabase 
{
Scanner console;  

private MusicPlayer song1=null, song2=null, song3=null, song4=null;

    public SongDatabase() 
    {
        this.console = new Scanner(System.in);
    }
private MusicPlayer getFromUser() 
    {
        MusicPlayer song = new Song();
        System.out.println("Name of song:");
        song.setName(console.next());
        System.out.println("Artist:");
        song.setArtist(console.next());
        System.out.println("File size (MB):");
        song.setFileSize(console.nextInt());
        System.out.println("Duration (seconds):");
        song.setDuration(console.nextInt());
        System.out.println("Song successfully added.");
        System.out.println("");
        return song;
    }
public void addNewSong()
    {        
        if (song1 == null) 
        {
            song1 = getFromUser();
        }
        else if (song2 == null) 
        {
            song2 = getFromUser();
        }    
        else if (song3 == null) 
        {
            song3 = getFromUser();
        }
        else if (song4 == null) 
        {
            song4 = getFromUser();
        }
        else 
        {
            System.out.println("The database is currently full. Please delete a song before adding a new one.");
            System.out.println("");
        }    
}
public Song getSong(int songNumber) 
    {
        if (songNumber == 1){
            return song1;
        }
        else if (songNumber == 2)
        {   
            return song2;
        }
        else if (songNumber == 3)
        {
            return song3;
        }
        else if (songNumber == 4)
        {
            return song4;
        }
        else 
        {
            return song1; //This condition will never be met as the switch statement limits input to 1-4.
        }
    }   
}
