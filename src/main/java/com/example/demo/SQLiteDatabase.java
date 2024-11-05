package com.example.demo;
import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.MedProc;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.Icon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteDatabase {
    static Connection conn;
    PreparedStatement ps;
    public SQLiteDatabase() throws Exception{
        String url = "jdbc:sqlite:Cow.db";
        conn = DriverManager.getConnection(url);

    }
//    public void insertCow(Cow newCow){
//
//        String sql = "insert into cowModel values (?,?,?,?,?,?,?,?,?,?)";
//
//        try {
//            ps = conn.prepareStatement(sql);
//
//            conn.setAutoCommit(false);
//
//            ps.setString(1, newCow.getID());
//            ps.setString(2, newCow.getFarmTag());
//            ps.setString(3, String.valueOf(newCow.getDateOfBirth()));
//            ps.setString(4, String.valueOf(newCow.getDateOfDeath()));
//            ps.setString(5, newCow.getGenderString());
//            ps.setString(6, newCow.getCategoryString());
//            ps.setString(7, String.valueOf(newCow.getSire()));
//            ps.setString(8, String.valueOf(newCow.getDam()));
//            ps.setFloat(9, (float) newCow.getCurrentWeight());
//            ps.setString(10, null);
//
//
//            ps.executeUpdate();
//
//            conn.commit();
//        } catch (SQLException ex){
//            Logger.getLogger(SQLiteDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void insertCowWeight(Weight newCowWeight){
        PreparedStatement ps;
        String sql = "insert into cowWeight values (?,?)";

        try {
            ps = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            ps.setFloat(1, newCowWeight.getWeight());
            ps.setString(2, String.valueOf(newCowWeight.getDate()));

            ps.executeUpdate();

            conn.commit();
        } catch (SQLException ex){
            Logger.getLogger(SQLiteDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertCowMedical(MedProc newCowMedical){
        PreparedStatement ps;
        String sql = "insert into cowMedical values (?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);

            conn.setAutoCommit(false);

            ps.setString(1, newCowMedical.getDate());
            ps.setString(2, newCowMedical.getProcedure());
            ps.setString(3, newCowMedical.getReason());
            ps.setString(4, newCowMedical.getProduct());
            ps.setString(5, newCowMedical.getDosage());
            ps.setString(6, newCowMedical.getRoute());
            ps.setString(7, newCowMedical.getNotes());


            ps.executeUpdate();

            conn.commit();
        } catch (SQLException ex){
            Logger.getLogger(SQLiteDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCow(String newCow) throws SQLException{
        conn.setAutoCommit(false);

        String sql = "delete from CowModelTable where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newCow);

        conn.commit();
    }

    public void deleteCowWeight(Weight newCowWeight) throws SQLException{
        conn.setAutoCommit(false);

        String sql = "delete from CowModelTable where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setFloat(1, newCowWeight.getWeight());

        conn.commit();
    }

    public void deleteCowMedial(MedProc newCowMedical) throws SQLException{
        conn.setAutoCommit(false);

        String sql = "delete from CowModelTable where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newCowMedical.getDate());

        conn.commit();
    }


    public void displayCowID(){
        String sql = "select id, farmTag from cowModel";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println(rs.getString("id") + "\t" + rs.getString("farmTag"));
            }
        } catch (SQLException e){
            Logger.getLogger(SQLiteDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /*public static ObservableList<Cow> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "select * from cowmodeltable";

        try(Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.getResultSet();
            ObservableList<Cow> cowList = getCowsObjects(resultSet);

            return cowList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*private static ObservableList<Cow> getCowsObjects(ResultSet resultSet) {
        ObservableList<Cow> cowList = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                Cow newC = new Cow(resultSet.getString);
                newC.setID(resultSet.getString('id'));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cowList;
    }

     */

    public static void main(String[] args) throws Exception{
        SQLiteDatabase database = new SQLiteDatabase();
        database.displayCowID();
    }
}

