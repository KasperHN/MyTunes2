/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.util.List;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class Playlist {

    private List<SongModel> Playlist; //Playlist
    private int songCount; // Antal sange i Playlist
    private final int ID; // Unique playlist ID
    private String title;

    public Playlist(int songCount, String title, int ID) {
        this.songCount = songCount;
        this.title = title;
        this.ID = ID;
    }

    public Playlist(int i, int i0, String title, int newestPlaylist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getID() 
    {
        return ID;
    }

    public List<SongModel> getSongList() {
        return Playlist;
    }

    public void setSongList(List<SongModel> songList) {
        this.Playlist = songList;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Name=" +title + "Total song count =" + songCount;
    }
}
