/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import be.Song;
import java.util.List;
import dal.SongDAO;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author chri9
 */
public class SongBLL {

    private ObservableList<Song> songsAll;
    private SongDAO songdao;
    private static SongBLL instance;
    
    public SongBLL()
            {
              songsAll = FXCollections.observableArrayList();
            }
      public ObservableList<Song> getAllSongs() {
        return songsAll;
    }

    public List<Song> getAlleSongs() {
        return songdao.getAllSongs();
    }

    public void createSong(Song song) {
        songdao.createSong(song);
    }

    public void loadSongs() {
        songsAll.clear();
        songsAll.addAll(getAllSongs());
    }

    public static SongBLL getInstance() throws IOException, Exception {
        if (instance == null) {
            instance = new SongBLL();
        }
        return instance;
    }
}
