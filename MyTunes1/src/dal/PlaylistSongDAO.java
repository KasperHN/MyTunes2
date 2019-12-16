/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import be.Playlist;
import be.SongModel;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class PlaylistSongDAO {

    SQLServerDataSource ds;

    /*
    Opstarter Konstructoren. Getter Arraylisten fra DatabaseConnectionDAO og gør brug af Databasen
     */
    public PlaylistSongDAO() throws IOException {
        this.ds = new SQLServerDataSource();
        DatabaseConnector connectionInfo = new DatabaseConnector();
        List<String> infoList = connectionInfo.getDatabaseInfo();
        ds.setDatabaseName(infoList.get(0));
        ds.setUser(infoList.get(1));
        ds.setPassword(infoList.get(2));
        ds.setPortNumber(Integer.parseInt(infoList.get(3)));
        ds.setServerName(infoList.get(4));
    }

//    /*
//    Getter playlist køen Som laver playlist af sange.
//     */
//    public List<SongModel> getPlaylistSongs(int songid) {
//        List<SongModel> newSongList = new ArrayList();
//        try (Connection con = ds.getConnection()) {
//            String query = "SELECT * FROM Playlist INNER JOIN Song ON PlaylistSong.songid = Song.id WHERE PlaylistSong.PlaylistID = ? ORDER by locationInListID desc"; // Henter alle sange fra en playliste
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, songid);
//            ResultSet rs = preparedStmt.executeQuery();
//            while (rs.next()) {
//                SongModel song = new SongModel(rs.getString("title"), rs.getString("artist"), rs.getString("genre"), rs.getString("songlocation"), rs.getInt("songid")); // Sets up a song object
//                song.setLocationInList(rs.getInt("locationInListID")); // indsætter int lister locationer.
//                newSongList.add(song); //Tilføjer sange til sang array listen.
//            }
//            return newSongList;
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//            return null;
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return null;
//        }
//    }
//
//    /*
//    Fjerner en specific sang fra aller playlister.
//     */
//    public void deleteFromPlaylistSongsEverything(SongModel songToDelete) {
//        try (Connection con = ds.getConnection()) {
//            String query = "DELETE from Playlist WHERE songid = ?";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, songToDelete.getSongId());
//            preparedStmt.execute();
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    /*
//    Tilføjer en sang til playliste.
//     */
//    public SongModel addToPlaylist(Playlist playlist, SongModel song) {
//        String sql = "INSERT INTO PlaylistSong(PlaylistID,SongId,locationInListID) VALUES (?,?,?)";
//        int songId = -1;
//        try (Connection con = ds.getConnection()) {
//            PreparedStatement ps = con.prepareStatement(sql);
//            songId = getNewestSongInPlaylist(playlist.getSongId()) + 1;
//            ps.setInt(1, playlist.getSongId());
//            ps.setInt(2, song.getSongId());
//            ps.setInt(3, songId);
//            ps.addBatch();
//            ps.executeBatch();
//          song.setLocationInList(songId);
//            return song; // returnere sang objecter.
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//            return null;
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            return null;
//        }
//    }

    /*
    Henter nyeste ID til playliste.
     */
    private int getNewestSongInPlaylist(int songid) {
        int newestSongId = -1;
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM PlaylistSong WHERE PlaylistID = ? ORDER by locationInListID desc";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, songid);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestSongId = rs.getInt("songLocationInListID");
            }
            System.out.println(newestSongId);
            return newestSongId;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestSongId;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestSongId;
        }
    }

    /*
    Sletter en playlist fra en playlist sang tabel i databasen.
     */
//    public void deleteFromPlaylistSongsEverything(Playlist play) {
//        try (Connection con = ds.getConnection()) {
//            String query = "DELETE from PlaylistSong WHERE PlaylistID = ?";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, play.getID());
//            preparedStmt.execute();
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    /*
//    Skifter sangens positionerne på listen.
//     */
//    public void editSongPosition(Playlist selectedItem, SongModel selected, SongModel exhangeWith) {
//        try (Connection con = ds.getConnection()) {
//            String query = "UPDATE PlaylistSong set songLocationInListID = ? WHERE PlaylistID = ? AND songid = ? AND songLocationInListID = ? ";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, exhangeWith.getSongLocationInList());
//            preparedStmt.setInt(2, selectedItem.getSongId());
//            preparedStmt.setInt(3, selected.getSongId());
//            preparedStmt.setInt(4, selected.getSongLocationInList());
//            preparedStmt.addBatch();
//            preparedStmt.setInt(1, selected.getSongLocationInList());
//            preparedStmt.setInt(2, selectedItem.getSongId());
//            preparedStmt.setInt(3, exhangeWith.getSongId());
//            preparedStmt.setInt(4, exhangeWith.getSongLocationInList());
//            preparedStmt.addBatch();
//            preparedStmt.executeBatch();
//            int temp = selected.getSongLocationInList(); // Laver en midlertidig ID
//            selected.setLocationInList(exhangeWith.getSongLocationInList());
//            exhangeWith.setLocationInList(temp);
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    /*
//    Fjerner en specific sang fra Playlisten.
//     */
//    public void removeSongFromPlaylist(Playlist selectedItem, SongModel selectedSong) {
//        try (Connection con = ds.getConnection()) {
//            String query = "DELETE from PlaylistSong WHERE PlaylistID = ? AND songid = ? AND locationInListID = ?";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, selectedItem.getSongId());
//            preparedStmt.setInt(2, selectedSong.getSongId());
//            preparedStmt.setInt(3, selectedSong.getSongLocationInList());
//            preparedStmt.execute();
//        } catch (SQLServerException ex) {
//            System.out.println(ex);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
}
