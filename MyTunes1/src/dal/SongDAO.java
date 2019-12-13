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
import be.SongModel;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class SongDAO {

    SQLServerDataSource ds;

    /*
    Starter constructoren. Getter også informationen fra DatabaseConnectionDAO og samler hele klassen.
     */
    public SongDAO() throws IOException {
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
    Getter alle sange i databasen.
     */
    public List<SongModel> getAllSongs() {
        List<SongModel> allSongs = new ArrayList<>();
        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM Song";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) { // Skaber og tilføjer sang objecter til array listen.
                song = new Song(rs.getString("songid"), rs.getString("artist"), rs.getString("title"), rs.getInt("genre"), rs.getString(""));
                allSongs.add(song);
            }
            return allSongs; //Returnere en fuld liste.
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /*
    Laver en sang og tilføjer den til databasen.
     */
    //public SongModel createSong(Song song) throws DalException 
    {
        String sql = "INSERT INTO Song(songid,artist,title,genre,songlocation) VALUES (?,?,?,?,?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, SongModel.songid());
            ps.setString(2, SongModel.artist());
            ps.setString(3, SongModel.title());
            ps.setString(4, SongModel.genre());
            ps.setString(5, SongModel.songlocation);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        SongModel song = new SongModel(songid, artist, title, genre, songlocation, getNewestSongID()); //Laver et sang object
        return song; //Returnere sang objected
        
        // Attempts to update the database
            int affectedRows = ps.executeUpdate();
            if (affectedRows < 1)
            {
                throw new SQLException("Can't save song");
            }
    }
    
   

    /*
    Getter top sang IDerne fra databasen så det er muligt at skabe sang objected.
     */
    private int getNewestSongID() {
        int newestID = -1; // Vidkårligt ID ikke fundet.
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM Song ORDER by songid desc"; //Vælg det højeste ID 
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("songid");
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

    public void deleteSong(SongModel songToDelete) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from Song WHERE songid = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, songToDelete.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public SongModel updateSong(SongModel song, String title, String artist, String genre, String songlocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SongModel createSong(String title, String artist, String genre, String songlocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
