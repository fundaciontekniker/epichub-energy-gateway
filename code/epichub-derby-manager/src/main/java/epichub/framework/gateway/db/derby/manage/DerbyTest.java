package epichub.framework.gateway.db.derby.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class DerbyTest
{
    private static String dbURL = "jdbc:derby://epichub_dev:1527/epichubdb;user=epichub;password=epichub";
    private static String tableName = "EPICHUB.GATEWAY_DEVICE";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args)
    {
        createConnection();
        updateDevice(1,"AVAILABLE");
        updateDevice(6,"AVAILABLE");
        updateDevice(8,"AVAILABLE");
        selectRestaurants();
        shutdown();
    }
    
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void selectRestaurants()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select DBID,ID,STATE from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
            	String me="";
            	for (int i=1; i<=numberCols; i++)
                {
            		me+=results.getObject(i)+"\t\t";
                   
                }
            	 System.out.println(me);  
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void updateDevice(int dbId, String state)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("UPDATE EPICHUB.GATEWAY_DEVICE SET STATE='"+state+"' WHERE DBID="+dbId);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                //DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
}