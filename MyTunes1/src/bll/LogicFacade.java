/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.List;
import javafx.collections.ObservableList;
import be.Playlist;
import be.Song;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public interface LogicFacade {

    /*
    Laver en liste af alle Playlister
     */
    public List<Playlist> getAllPlaylists();

    /*
    Skaber af Playlister
     */
    public Playlist createPlaylist(String title);

    /*
    Konfiguerer navne på Playlister
     */
    public void editPlaylist(Playlist get, String text);

    /*
    Sletter Playlister
     */
    public void deletePlaylist(Playlist play);

    /*
    Laver en liste for nye sange
     */
    public List<Song> getAllSongs();

    /*
    Skaber paramterne for sangen
     */
    public Song createSong(String title, String artist, String genre, String songlocation);

    /*
    Opdatere sange med givne parametere
     */
    public Song updateSong(Song songToDelete, String title, String artist, String genre, String songlocation);

    /*
    Sletter specificerede sange
     */
    public void deleteSong(Song songToDelete);

    /*
    Tilføjer sange til en specificeret Playliste
     */
    public Song addToPlaylist(Playlist playlist, Song song);

    /*
    Fjerner sange fra specificeret liste
     */
    public void removeSongFromPlaylist(Playlist selectedItem, Song selectedSong);

    /*
    Ændre positionen for sangen på playlisten
     */
    public void editSongPosition(Playlist selectedItem, Song selected, Song exhangeWith);

    /*
    Søger sange som matcher søge kriteriet
     */
    public ObservableList<Song> search(ObservableList<Song> items, String text);

    /*
    Getter alle Katagorierne
     */
    public List<String> getAllGenre();

    /*
    Skaber en ny Katagori
     */
    public void createGenre(String title);

    /*
    Sletter Defineret Katagori
     */
    public void deleteGenre(String title);

}
