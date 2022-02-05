/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ksaum
 */
public class DbConnection {
    Connection con;
    public Connection dbConnect(String dbname){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/"+dbname);
            System.out.println("connected successfully");
            this.con=con;
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return null;
    }
    public void insert(int id,String n,String c,String d){
        try{
            PreparedStatement ps=con.prepareStatement("insert into agri values(?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,n);
            ps.setString(3,c);
            ps.setString(4,d);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(int id,String n,String c,String d){
        try{
            PreparedStatement ps=null;
            ps=con.prepareStatement("update agri set Fname=?,City=?,State=? where FarmerNo=?");
            ps.setInt(4,id);
            ps.setString(1,n);
            ps.setString(2,c);
            ps.setString(3,d);
            if(ps.executeUpdate()>0)
              System.out.println("updated successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet search(String d)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from agri where state=?");
        ps.setString(1, d);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet searchOne(int id)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from agri where FarmerNo=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
}
