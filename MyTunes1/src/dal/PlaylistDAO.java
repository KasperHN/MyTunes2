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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import be.Playlist;
import be.SongModel;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class PlaylistDAO {

    PlaylistSongDAO PlaylistSongInfo = new PlaylistSongDAO(); // Opstarter PlaylistDAO klassen
    SQLServerDataSource ds;

    /*
    Opstarter konstructoren getter array listen for DatabaseConnectionDAO.
     */
    public PlaylistDAO() throws IOException {
        this.ds = new SQLServerDataSource();
        DatabaseConnector connectionInfo = new DatabaseConnector();
        List<String> infoList = connectionInfo.getDatabaseInfo();
        ds.setDatabaseName(infoList.get(0));
        ds.setUser(infoList.get(1));
        ds.setPassword(infoList.get(2));
        ds.setPortNumber(Integer.parseInt(infoList.get(3)));
        ds.setServerName(infoList.get(4));
    }

    /*
    Henter alle Playlister fra Databasen
     */
    public List<Playlist> getAllPlaylists() {
        List<Playlist> allPlaylists = new ArrayList<>(); // Tilføjer playliste tabel.

        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM Playlist";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                List<SongModel> allSongs = PlaylistSongInfo.getPlaylistSongs(id); // Tilføjer alle sange til playliste
                Playlist pl = new Playlist(allSongs.size(), countTotalTime(allSongs), name, id); // Skaber et nyt playlist object.
                pl.setSongList(allSongs); // Opstiller sang liste
                allPlaylists.add(pl); // Tilføjer playliste til playlist tabellen.
            }
            return allPlaylists; // Returnere playlisten.
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /*
    Tæller alle sekunder sammen på en playliste.
     */
    private int countTotalTime(List<SongModel> allSongs) {
        int totalTime = 0;
        for (SongModel allSong : allSongs) {
            totalTime += allSong.getPlaytime();
        }
        return totalTime; //Returnere sekunder.
    }

    /*
    Tilføjer playlist med givet navn.
     */
    public Playlist createPlaylist(String name) {
        String sql = "INSERT INTO Playlist(name) VALUES (?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Playlist playlist = new Playlist(0, 0, name, getNewestPlaylist()); //Skaber en playlist og specificere at der ikke findes nogen sange.
        return playlist;
    }

    /*
    Getter den nyeste Playliste ID i række til at skabe en ny playliste.
     */
    private int getNewestPlaylist() {
        int newestID = -1;
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM Playlist ORDER by id desc";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("id");
            }
            return newestID;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestID;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestID;
        }
    }

    /*
    Opdatere specificeret playliste med given navn.
     */
    public void updatePlaylist(Playlist selectedItem, String name) {
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE Playlist set name = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, selectedItem.getID());
            preparedStmt.executeUpdate();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /*
    Sletter Specificeret playlist fra databasen.
     */
    public void deletePlaylist(Playlist play) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from Playlist WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, play.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
