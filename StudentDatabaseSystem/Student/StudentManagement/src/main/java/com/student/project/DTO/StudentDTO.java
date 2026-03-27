package com.student.project.DTO;

import com.student.project.Enums.Gender;
import java.util.Date;

public class StudentDTO {
    private int serialNo;
    private String name;
    private Gender gender;
    private String regNo;
    private String email;
    private Date dateOfBirth;

    public StudentDTO(int serialNo, String name, Gender gender, String regNo, String email, Date dateOfBirth) {
        this.serialNo = serialNo;
        this.name = name;
        this.gender = gender;
        this.regNo = regNo;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegNo() {
        return regNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}