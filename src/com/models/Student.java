/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author Prabhashwara
 */
public class Student {
    private int id;
    private String acadamicYear;
    private String program;
    private String groupNo;
    private String subGroupNo;
    private String groupId;
    private String subGroupId;

    public Student(String acadamicYear, String program, String groupNo, String subGroupNo, String groupId, String subGroupId) {
        this.acadamicYear = acadamicYear;
        this.program = program;
        this.groupNo = groupNo;
        this.subGroupNo = subGroupNo;
        this.groupId = groupId;
        this.subGroupId = subGroupId;
    }

    public Student(int id, String acadamicYear, String program, String groupNo, String subGroupNo, String groupId, String subGroupId) {
        this.id = id;
        this.acadamicYear = acadamicYear;
        this.program = program;
        this.groupNo = groupNo;
        this.subGroupNo = subGroupNo;
        this.groupId = groupId;
        this.subGroupId = subGroupId;
    }

    public Student() {
    }

    public String getSubGroupNo() {
        return subGroupNo;
    }

    public void setSubGroupNo(String subGroupNo) {
        this.subGroupNo = subGroupNo;
    }
    
    public Student(int id, String acadamicYear, String program, String groupNo, String groupId, String subGroupId) {
        this.id = id;
        this.acadamicYear = acadamicYear;
        this.program = program;
        this.groupNo = groupNo;
        this.groupId = groupId;
        this.subGroupId = subGroupId;
    }

    public Student(String acadamicYear, String program, String groupNo, String groupId, String subGroupId) {
        this.acadamicYear = acadamicYear;
        this.program = program;
        this.groupNo = groupNo;
        this.groupId = groupId;
        this.subGroupId = subGroupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcadamicYear() {
        return acadamicYear;
    }

    public void setAcadamicYear(String acadamicYear) {
        this.acadamicYear = acadamicYear;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(String subGroupId) {
        this.subGroupId = subGroupId;
    }
}
