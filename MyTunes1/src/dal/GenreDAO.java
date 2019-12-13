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

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class GenreDAO { // Indleder GenreDAO Klassen

    SQLServerDataSource ds;

    /*
    Indleder constructoren. Getter Arraylisten fra DatabaseConnectionDAO og opstiller instillingerne så de kan bruge den.
     */
    public GenreDAO() throws IOException {
        this.ds = new SQLServerDataSource();
        DatabaseConnector connectionInfo = new DatabaseConnector();
        List<String> infoList = connectionInfo.getDatabaseInfo();
        ds.setDatabaseName(infoList.get(0));
        ds.setUser(infoList.get(1));
        ds.setPassword(infoList.get(2));
        ds.setPortNumber(Integer.parseInt(infoList.get(3)));
        ds.setServerName(infoList.get(4));
    }

    public List<String> getAllCategories() {
        List<String> allGenre = new ArrayList<>(); // Laver en string for at katogorisere

        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM genre";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                allGenre.add(rs.getString("title")); // Tilføjer katagori til string Array.
            }
            return allGenre; // Returnere string array
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /*
    Indsætter en ny katagori i katagori tabellen.
     */
    public void createCategory(String title) {
        String sql = "INSERT INTO genre VALUES (?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /*
    Sletter katagori fra katagori tabellen.
     */
    public void deleteCategory(String title) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from genre WHERE title = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<String> getAllGenre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createGenre(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteGenre(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
