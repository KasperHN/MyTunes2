/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author kaspe
 */
public class DatabaseConnector
{

    private SQLServerDataSource dataSource;

    public DatabaseConnector() throws IOException
    {
        Properties props = new Properties();
        props.load(new FileReader("DBSettings.txt"));
        dataSource = new SQLServerDataSource();
        dataSource.setDatabaseName(props.getProperty("database"));
        dataSource.setUser(props.getProperty("user"));
        dataSource.setPassword(props.getProperty("password"));
        dataSource.setServerName(props.getProperty("server"));
    }

    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }

    public SongDAO() throws IOException 
    {
        this.dataSource = new SQLServerDataSource();
        DatabaseConnector connectionInfo = new DatabaseConnector();
        List<String> infoList = connectionInfo.getDatabaseInfo();
        dataSource.setDatabaseName(infoList.get(0));
        dataSource.setUser(infoList.get(1));
        dataSource.setPassword(infoList.get(2));
        dataSource.setPortNumber(Integer.parseInt(infoList.get(3)));
        dataSource.setServerName(infoList.get(4));
    }

    public List<String> getDatabaseInfo() throws IOException 
    {
        List<String> info = new ArrayList();
        String source = "data/DBSettings.txt";
        File file = new File(source);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
    {
        String line;
        while ((line = reader.readLine()) != null) 
        {
            if (!line.isEmpty()) 
            {
                try 
                {
                    info.add(line);
                } 
                catch (Exception ex) 
                {
                    System.out.println(ex);
                }
            }
        }
    }
        return info;
    }
}
