
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package be;

import bll.LogicFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */

public class SongModel 
{
    private String title; // Title på sang
    private String artist; // Kunstner af sang
    private String genre; 
    private String songlocation; // Sanges lokation
    private int songid; // Unique Sang ID i Databasen

    public SongModel(String title, String artist, String genre, String songlocation, int songid) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.songlocation = songlocation;
        this.songid = songid;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSonglocation() {
        return songlocation;
    }

    public void setSonglocation(String songlocation) {
        this.songlocation = songlocation;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }
    
}
   