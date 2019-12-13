
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
    private String genre; 
    private String songlocation; // Sanges lokation
    private final int ID; // Unique Sang ID i Databasen

    public SongModel(String title, String artist, String genre,String songlocation, int ID) 
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.songlocation = songlocation;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String category) {
        this.genre = genre;
    }

    public String getSongLocation() {
        return songlocation;
    }

    public void setSongLocation(String location) {
        this.songlocation = location;
    }

    @Override
    public String toString() {
        return title;
    }
}