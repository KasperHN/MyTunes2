/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.List;
import javafx.collections.ObservableList;
import be.Playlist;
import be.SongModel;

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
    public Playlist createPlaylist(String name);

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
    public List<SongModel> getAllSongs();

    /*
    Skaber paramterne for sangen
     */
    public SongModel createSong(String title, String artist, String category, int playtime, String location);

    /*
    Opdatere sange med givne parametere
     */
    public SongModel updateSong(SongModel songToDelete, String title, String artist, String category, int playtime, String location);

    /*
    Sletter specificerede sange
     */
    public void deleteSong(SongModel songToDelete);

    /*
    Tilføjer sange til en specificeret Playliste
     */
    public SongModel addToPlaylist(Playlist playlist, SongModel song);

    /*
    Fjerner sange fra specificeret liste
     */
    public void removeSongFromPlaylist(Playlist selectedItem, SongModel selectedSong);

    /*
    Ændre positionen for sangen på playlisten
     */
    public void editSongPosition(Playlist selectedItem, SongModel selected, SongModel exhangeWith);

    /*
    Søger sange som matcher søge kriteriet
     */
    public ObservableList<SongModel> search(ObservableList<SongModel> items, String text);

    /*
    Getter alle Katagorierne
     */
    public List<String> getAllCategories();

    /*
    Skaber en ny Katagori
     */
    public void createCategory(String name);

    /*
    Sletter Defineret Katagori
     */
    public void deleteCategory(String name);

}
