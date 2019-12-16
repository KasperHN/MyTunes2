/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import be.Playlist;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import be.SongModel;
import be.SongModel;
import dal.GenreDAO;
import dal.PlaylistDAO;
import dal.PlaylistSongDAO;
import dal.SongDAO;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */


public class Manager implements LogicFacade {

    private final PlaylistDAO playListDAO;
    private final SongDAO SongDAO;
    private final SongFilter songSearcher;
    private final PlaylistSongDAO PlaylistSongInfo;
    private final GenreDAO GenreDAO;
    

    /*
    Starter alle dal klasser
     */
    public Manager() throws IOException 
    {
        playListDAO = new PlaylistDAO();
        SongDAO = new SongDAO();
        songSearcher = new SongFilter();
        PlaylistSongInfo = new PlaylistSongDAO();
        GenreDAO = new GenreDAO();
    }

//    @Override
//    public List<Playlist> getAllPlaylists()  //getter for playliste
//    {
//        return playListDAO.getAllPlaylists();
//    }

//    @Override
//    public void deletePlaylist(Playlist play) 
//    {
//        PlaylistSongInfo.deleteFromPlaylistSongsEverything(play); // Fjerner sange fra playliste
//        playListDAO.deletePlaylist(play); 
//    }

    @Override
    public List<SongModel> getAllSongs() //getter for sange
    {
        return SongDAO.getAllSongs();
    }

    @Override
    public void deleteSong(SongModel songToDelete) 
    {
       // PlaylistSongInfo.deleteFromPlaylistSongsEverything(songToDelete);// Fjerner sange fra databasen
        SongDAO.deleteSong(songToDelete); 
    }

//    @Override
    public SongModel updateSong(SongModel song, String title, String artist, String genre, String songlocation) {
       return SongDAO.updateSong(song, title, artist, genre, songlocation);
}

//    @Override
//    public Playlist createPlaylist(String title) 
//    {
//        return playListDAO.createPlaylist(title);
//    }

//    @Override
//    public SongModel addToPlaylist(Playlist playlist, SongModel song) 
//    {
//        return PlaylistSongInfo.addToPlaylist(playlist, song);
//    }

//    @Override
//    public void removeSongFromPlaylist(Playlist selectedItem, SongModel selectedSong) 
//    {
//        PlaylistSongInfo.removeSongFromPlaylist(selectedItem, selectedSong);
//    }

    @Override
    public void editPlaylist(Playlist get, String text) 
    {
        playListDAO.updatePlaylist(get, text);
    }

//    @Override
//    public void editSongPosition(Playlist selectedItem, SongModel selected, SongModel exhangeWith) 
//    {
//        PlaylistSongInfo.editSongPosition(selectedItem, selected, exhangeWith);
//    }

    @Override
    public ObservableList<SongModel> search(ObservableList<SongModel> items, String text) 
    {
        return songSearcher.search(items, text);
    }
    
    @Override
    public SongModel createSong(String title, String artist, String genre, String songlocation) {
        return SongDAO.createSong(title, artist, genre, songlocation);  
    }

    @Override
    public List<String> getAllGenre() {
        return GenreDAO.getAllGenre();
    }

    @Override
    public void createGenre(String title) {
        GenreDAO.createGenre(title);
    }

    @Override
    public void deleteGenre(String title) {
        GenreDAO.deleteGenre(title);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePlaylist(Playlist play) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Playlist createPlaylist(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SongModel addToPlaylist(Playlist playlist, SongModel song) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSongFromPlaylist(Playlist selectedItem, SongModel selectedSong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editSongPosition(Playlist selectedItem, SongModel selected, SongModel exhangeWith) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
