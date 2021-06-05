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
public class Subject {
    public void insertUpdateDeleteSubject(char operation,Integer id,String subject_code,String subject_name,String offered_year,String offered_semester,Integer no_of_lec_hr,
                                            Integer no_of_tute_hr,Integer no_of_lab_hr,Integer no_of_eve_hr)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO subject(subject_code, subject_name, offered_year, offered_semester, no_of_lec_hr, no_of_tute_hr, no_of_lab_hr,no_of_eve_hr) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, subject_code);
                ps.setString(2, subject_name);
                
                ps.setString(3, offered_year);
                ps.setString(4, offered_semester);
                ps.setInt(5, no_of_lec_hr);
                ps.setInt(6, no_of_tute_hr);
                ps.setInt(7, no_of_lab_hr);
                ps.setInt(8, no_of_eve_hr);
                
                if (ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "New Subject Added");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void    fillSubjectJtable(JTable table, String valueToSearch)
    {
       Connection con = MyConnection.getConnection();
       PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `subject` WHERE CONCAT( `subject_code`, `subject_name`, `offered_year`, `offered_semester`, `no_of_lec_hr`, `no_of_tute_hr`, `no_of_lab_hr`, `no_of_eve_hr`)LIKE ?");
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
                row[5] = rs.getInt(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getInt(8);
                row[8] = rs.getInt(9); 
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

