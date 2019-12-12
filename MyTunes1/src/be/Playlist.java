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

    private List<SongModel> songList; //Playlist
    private int songCount; // Antal sange i Playlist
    private int totalTime; // Total tid af sange på playliste
    private final String totalTimeString; //Samme som overstående men i  hour:minute:second format
    private String name; // Navn på playliste
    private final int ID; // Unique playlist ID

    public Playlist(int songCount, int totalTime, String name, int ID) {
        this.songCount = songCount;
        this.totalTime = totalTime;
        totalTimeString = getTotalTimeString();
        this.name = name;
        this.ID = ID;
    }

    public int getID() 
    {
        return ID;
    }

    public List<SongModel> getSongList() {
        return songList;
    }

    public void setSongList(List<SongModel> songList) {
        this.songList = songList;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Name=" + name + "Total song count =" + songCount + ", Total play Time=" + totalTime;
    }

    /*
    Konverterer sange til minutter sekunder og timer.
     */
    public String getTotalTimeString() {
        String minutesString;
        String secondString;
        int hours = totalTime / 3600;
        int minutes = (totalTime % 3600) / 60;
        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }
        int seconds = totalTime % 60;
        if (10 > seconds) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        return hours + ":" + minutesString + ":" + secondString;
    }
}
