/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Lecturer {
    public void insertUpdateDeleteLecturer(char operation,Integer id,String employee_id,String employee_name,String faculty,String department,String center,
                                            String building,Integer level,Integer rank)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO lecturer(emloyee_id, employee_name, faculty, department, center, building, level, rank) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, employee_id);
                ps.setString(2, employee_name);
                
                ps.setString(3, faculty);
                ps.setString(4, department);
                ps.setString(5, center);
                ps.setString(6, building);
                ps.setInt(7, level);
                ps.setInt(8, rank);
                
                if (ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "New Lecturer Added");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(operation == 'u')
        {
            try {
                ps = con.prepareStatement("UPDATE `lecturer` SET `emloyee_id`= ?,`employee_name`= ?,`faculty`= ?,`department`= ?,`center`= ?,`building`= ?,`level`= ?,`rank`= ?, WHERE lid = ?");
                ps.setString(1, employee_id);
                ps.setString(2, employee_name);                
                ps.setString(3, faculty);
                ps.setString(4, department);
                ps.setString(5, center);
                ps.setString(6, building);
                ps.setInt(7, level);
                ps.setInt(8, rank);
                ps.setInt(9, id);
                 
                if (ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Lecturer Data Updated");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(operation == 'd')
        {
            try {
                ps = con.prepareStatement("DELETE FROM `lecturer` WHERE = `lid` = ?");
                ps.setString(1, employee_id);
                ps.setString(2, employee_name);                
                ps.setString(3, faculty);
                ps.setString(4, department);
                ps.setString(5, center);
                ps.setString(6, building);
                ps.setInt(7, level);
                ps.setInt(8, rank);
                ps.setInt(9, id);
                 
                if (ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, " Lecturer Data Deleted");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
    }
    
    public void    fillLecturerJtable(JTable table, String valueToSearch)
    {
       Connection con = MyConnection.getConnection();
       PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `lecturer` WHERE CONCAT( `emloyee_id`, `employee_name`, `faculty`, `department`, `center`, `building`, `level`, `rank`)LIKE ?");
            ps.setString(1, "%"+ valueToSearch+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[9];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getInt(8);
                row[8] = rs.getInt(9); 
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
