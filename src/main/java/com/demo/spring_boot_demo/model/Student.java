package com.demo.spring_boot_demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Student_Details")
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int rollNo;
   @Column (name = "name")
    public String name;
    @Column (name = "age")
    public int age;
    @Column (name = "phoneNo")
    public String phoneNo;
    @Column (name = "fatherName")
    public String fatherName;
    @Column(name="mothersName")
    public String mothersName;
    @Column(name="fatherOccupation")
    public String fatherOccupation;

    public Student(int rollNo, String name, int age, String phoneNo, String fatherName, String mothersName, String fatherOccupation, String motherOccupation) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.fatherName = fatherName;
        this.mothersName = mothersName;
        this.fatherOccupation = fatherOccupation;
        this.motherOccupation = motherOccupation;
    }
    public Student()
    {

    }

    public String motherOccupation;


    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }




}
