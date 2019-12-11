
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */

package be;

import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javazoom.jl.decoder.Manager;



/**
 *
 * @author jonas
 */

public class SongModel 
{
//Scanner console;  
//
//private MusicPlayer song1=null, song2=null, song3=null, song4=null;
//
//    public SongModel() 
//    {
//        this.console = new Scanner(System.in);
//        logiclayer = (LogicFacade) new Manager();
//    }
//    
//    private MusicPlayer getFromUser() 
//    {
//        MusicPlayer song = new Song();
//        System.out.println("Name of song:");
//        song.setName(console.next());
//        System.out.println("Artist:");
//        song.setArtist(console.next());
//        System.out.println("File size (MB):");
//        song.setFileSize(console.nextInt());
//        System.out.println("Duration (seconds):");
//        song.setDuration(console.nextInt());
//        System.out.println("Song successfully added.");
//        System.out.println("");
//        return song;
//    }
//    
//    public void addNewSong()
//    {        
//        if (song1 == null) 
//        {
//            song1 = getFromUser();
//        }
//        else if (song2 == null) 
//        {
//            song2 = getFromUser();
//        }    
//        else if (song3 == null) 
//        {
//            song3 = getFromUser();
//        }
//        else if (song4 == null) 
//        {
//            song4 = getFromUser();
//        }
//        else 
//        {
//            System.out.println("The database is currently full. Please delete a song before adding a new one.");
//            System.out.println("");
//        }    
//    }
    
       
    private ObservableList<SongModel> allSongs = FXCollections.observableArrayList();

    private final LogicFacade logiclayer;
   

    /*
    Gets all existing songs
    */
    public ObservableList<SongModel> getSongs() 
    {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(logiclayer.getAllSongs());
        return allSongs;
    }

    private String title; // Title of song
    private String artist; // Artist of song
    private String category; // Category of song
    private final int playtime; // Song playtime in seconds
    private final String playtimeString; // Song playtime in minute:second format
    private String location; // Song URL on the system
    private final int ID; // Unique song ID in the database
    private int locationInList; // Song ID thats hidden from the user. Its used mainly for moving the song up and down the list in database.
    private int IDinsideList = 0; // Song ID thats visable to the user once displayed in the Playlist songs table

    public SongModel(String title, String artist, String category, int playtime, String location, int ID) 
    {
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.playtime = playtime;
        playtimeString = getPlaytimeString();
        this.location = location;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getIDinsideList() {
        return IDinsideList;
    }

    public void setIDinsideList(int IDinsideList) {
        this.IDinsideList = IDinsideList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getLocationInList() {
        return locationInList;
    }

    public void setLocationInList(int locationInList) {
        this.locationInList = locationInList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPlaytime() {
        return playtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return title;
    }
    public String getPlaytimeString() 
    {
        String minutesString;
        String secondString;
        int minutes = playtime / 60;
        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }
        int seconds = playtime % 60;
        if (10 > seconds) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        return minutesString + ":" + secondString;
    }
}