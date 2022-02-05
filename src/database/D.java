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

/**
 *
 * @author ksaum
 */
public class D {
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
    public void insert(int id,int n,int c){
        try{
            int d=(id*n*(c/12))/100;
            PreparedStatement ps=con.prepareStatement("insert into Income values(?,?,?,?)");
            ps.setInt(1,id);
            ps.setInt(2,n);
            ps.setInt(3,c);
            ps.setInt(4,d);
            if(ps.executeUpdate()>0)
              System.out.println("inserted successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet searchOne(int id)throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Income where principal=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
   public void update(int p,int r,int t){
        try{
            System.out.println(r);
            int si=(p*r*(t/12))/100;
            PreparedStatement ps=null;
            ps=con.prepareStatement("update Income set Rate=?,Interest=? where principal=?");
            ps.setInt(1,r);
            ps.setInt(2,si);
            ps.setInt(3,p);
            if(ps.executeUpdate()>0)
              System.out.println("updated successfully");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  public ResultSet search()throws Exception{
        PreparedStatement ps = con.prepareStatement("select * from Income");
        ResultSet rs = ps.executeQuery();
 
        return rs;
    }
    
}
