package org.example.dao;

import org.example.model.Customer;

import java.sql.*;

public class cusDaoImp implements cusDao {

    // insert a customer in database
    @Override
    public int create(Customer cust) {
        int generatedId = -1; // Default value if insertion fails
        Connection con = DBcon.getConnection();

        if (con != null) {
            String query = "INSERT INTO ticket_windows (customerName, customerPeriod, lineNumber) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, cust.getName());
                pstmt.setInt(2, cust.getPeriod());
                pstmt.setInt(3, cust.getLine_number());

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            generatedId = rs.getInt(1); // Retrieve the generated ID
                        }
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        return generatedId; // Return the generated ID
    }


    // Delete a customer from database
    @Override
    public void delete(Customer cust){
        Connection con = DBcon.getConnection();
        if(con != null){
            String query = "DELETE FROM ticket_windows WHERE customerName=? AND lineNumber=?" +
                                                                    "ORDER BY id ASC LIMIT 1";
            try(PreparedStatement pstmt = con.prepareStatement(query)){
                pstmt.setString(1,cust.getName());
                pstmt.setInt(2,cust.getLine_number());

                pstmt.executeUpdate();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
            finally {
                try{
                    con.close();
                }
                catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }
    }


}
