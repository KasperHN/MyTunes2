
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package be;

import bll.LogicFacade;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javazoom.jl.decoder.Manager;



/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */

public class SongModel 
{

       
    private ObservableList<SongModel> allSongs = FXCollections.observableArrayList();

    private LogicFacade logiclayer;
   

    /*
    Getter for alle existerende sange
    */
    public ObservableList<SongModel> getSongs() 
    {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(logiclayer.getAllSongs());
        return allSongs;
    }

    private String title; // Title på sang
    private String artist; // Kunstner af sang
    private String category; // Katagori af sang
    private final int playtime; // Sanges spilletid i sekunder
    private final String playtimeString; // overstående men i minutter
    private String location; // Sanges lokation
    private final int ID; // Unique Sang ID i Databasen
    private int locationInList; // Skjuler ID for brugeren. Hovedsageligt brugt til at flytte på Sange i Databasen
    private int IDinsideList = 0; // Synlig ID for brugeren.

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