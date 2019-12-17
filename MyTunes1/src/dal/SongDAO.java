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
import be.Song;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<Song> getAllSongs() {
        ArrayList<Song> allSongs = new ArrayList<>();
        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM Song";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) 
            { 
// Skaber og tilføjer sang objecter til array listen.
                
                Song sm = new Song();
               // sm.setSongid(rs.getInt("songid"));
                sm.setTitle(rs.getString("title"));
                allSongs.add(sm);
                
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
    public void createSong(Song song) 
    {
        
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Song(songid, artist, title, genre, songlocation) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1, song.getSongid());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getTitle());
            ps.setString(4, song.getGenre());
            ps.setString(5, song.getFilePath());
        int affectedRows = ps.executeUpdate();
            if (affectedRows < 1)
            {
                throw new SQLException("Can't save song");
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                song.setSongid(rs.getInt(1));
            }
        } catch (SQLException ex)
        {
             Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
   

    /*
    Getter top sang IDerne fra databasen så det er muligt at skabe sang objected.
     */
    private int getNewestSongID() {
        int newestSongId = -1; // Vidkårligt ID ikke fundet.
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM Song ORDER by songid desc"; //Vælg det højeste ID 
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestSongId = rs.getInt("songid");
            }
            return newestSongId;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestSongId;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestSongId;
        }
    }

    public void deleteSong(Song songToDelete) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from Song WHERE songid = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, songToDelete.getSongid());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Song updateSong(Song song, String title, String artist, String genre, String songlocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Song createSong(String title, String artist, String genre, String songlocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
