package edu.jsu.mcis.cs310.tas_sp22;
import java.sql.*;
import java.util.HashMap;

public class TASDatabase {
    
    private final Connection connection;
    
    public TASDatabase() {
        
        this("tasuser", "c310e1", "localhost");    // call to overload constructor
        
    }
    
    public TASDatabase(String username, String password, String address) {
        
        this.connection = openConnection(username, password, address);  // establish connection to sql server
        
    }
    
    public Punch getPunch(int punchID) {
        Punch punch = null;
        String query = "SELECT * FROM event e WHERE id=?";
        boolean hasresults;
        ResultSet resultset = null;
        ResultSetMetaData rsmd = null;
        HashMap<String, String> hm = new HashMap<String, String>();
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, punchID);
            
            hasresults = pstmt.execute();
            if (hasresults) {
                resultset = pstmt.getResultSet();
                resultset.next();
                rsmd = resultset.getMetaData();
                for (int i = 1; i <= 5; i++) {
                    hm.put(rsmd.getColumnName(i), resultset.getString(i));  // key = table column header; value is row result
                }
                punch = new Punch(hm);  // new Punch object created with hashmap
            }
        }
        catch (Exception e) { e.printStackTrace(); }
        
        return punch;
    }
    
    private Connection openConnection(String u, String p, String a) {
        
        Connection c = null;
        
        if (a.equals("") || u.equals("") || p.equals(""))
            
            System.err.println("*** ERROR: MUST SPECIFY ADDRESS/USERNAME/PASSWORD BEFORE OPENING DATABASE CONNECTION ***");
        
        else {

            try {

                String url = "jdbc:mysql://" + a + "/tas_sp22_v1?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=EXCEPTION&serverTimezone=America/Chicago";

                c = DriverManager.getConnection(url, u, p);

            }
            catch (Exception e) { e.printStackTrace(); }
        
        }
        
        return c;
        
    }
    
    public void close() {
        
        try {
            
            this.connection.close();    // try to close connection
            
        }
        catch (Exception e) { e.printStackTrace(); }
        
    }
    
}
