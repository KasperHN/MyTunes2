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

    private List<Song> Playlist; //Playlist
    private int songCount; // Antal sange i Playlist
    private final int songid; // Unique playlist ID
    private String title;

    public Playlist(List<Song> Playlist, int songCount, int songid, String title) {
        this.Playlist = Playlist;
        this.songCount = songCount;
        this.songid = songid;
        this.title = title;
    }

    public List<Song> getPlaylist() {
        return Playlist;
    }

    public void setPlaylist(List<Song> Playlist) {
        this.Playlist = Playlist;
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

    public void setTitle(String title) {
        this.title = title;
    }


}
