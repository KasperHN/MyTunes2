
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package be;


/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */

public class SongModel 
{
    public String title; // Title på sang
    public String artist; // Kunstner af sang
    public String genre; 
    public String songlocation; // Sanges lokation
    public int songid; // Unique Sang ID i Databasen
    public String path;

//    public SongModel(String title, String artist, String genre, String songlocation, int songid) {
//        this.title = title;
//        this.artist = artist;
//        this.genre = genre;
//        this.songlocation = songlocation;
//        this.songid = songid;
//        this.path = path;
//    }
 public String getFilePath()
    {
        return path;
    }
 
  public  void setFilePath(String filePath)
    {
        this.path = path;
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
   