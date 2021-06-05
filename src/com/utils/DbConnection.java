/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import com.models.Student;
import com.models.Tags;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prabhashwara
 */
public class DbConnection {

    private static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return connection;

    }

    public static int insertSave(Tags t) {
        int status = 0;

        try {
            Connection connection;
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into tags(tagName, tagCode, reletedTag) values(?, ?, ?)");

            ps.setString(1, t.getTagName());
            ps.setString(2, t.getTagCode());
            ps.setString(3, t.getRelatedTag());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }

    public static List<Tags> getTags() {

        List<Tags> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from tags");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tags t = new Tags();

                t.setId((rs.getInt("id")));
                t.setTagName(rs.getString("tagName"));
                t.setTagCode(rs.getString("tagCode"));
                t.setRelatedTag(rs.getString("reletedTag"));

                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public static int update(Tags t) {
        int status = 0;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("update tags set tagName=?, tagCode=?, reletedTag=? where id=?");
            preparedStatement.setString(1, t.getTagName());
            preparedStatement.setString(2, t.getTagCode());
            preparedStatement.setString(3, t.getRelatedTag());
            preparedStatement.setInt(4, t.getId());

            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return status;
    }

    public static int delete(Tags t) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from tags where id=?");
            ps.setInt(1, t.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static int insertStudent(Student s) {
        int status = 0;

        try {
            Connection connection;
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into student"
                    + "(acadamicYear, program, groupNo, subGroupNo, groupId, subGroupId) values(?, ?, ?, ?, ?, ?)");

            ps.setString(1, s.getAcadamicYear());
            ps.setString(2, s.getProgram());
            ps.setString(3, s.getGroupNo());
            ps.setString(4, s.getSubGroupNo());
            ps.setString(5, s.getGroupId());
            ps.setString(6, s.getSubGroupId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static List<Student> getStudent() {

        List<Student> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();

                s.setId((rs.getInt("id")));
                s.setAcadamicYear(rs.getString("acadamicYear"));
                s.setProgram(rs.getString("program"));
                s.setGroupNo(rs.getString("groupNo"));
                s.setSubGroupNo(rs.getString("subGroupNo"));
                s.setGroupId(rs.getString("groupId"));
                s.setSubGroupId(rs.getString("subGroupId"));

                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }
    
    public static int updateStudent(Student s) {
        int status = 0;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement
            ("update student set acadamicYear=?, program=?, groupNo=?, subGroupNO=?, groupId=?, subGroupId=? where id=?");
            preparedStatement.setString(1, s.getAcadamicYear());
            preparedStatement.setString(2, s.getProgram());
            preparedStatement.setString(3, s.getGroupNo());
            preparedStatement.setString(4, s.getSubGroupNo());
            preparedStatement.setString(5, s.getGroupId());
            preparedStatement.setString(6, s.getSubGroupId());
            preparedStatement.setInt(7, s.getId());

            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return status;
    }
    
    public static int deleteStudent(Student s) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from student where id=?");
            ps.setInt(1, s.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }

}
